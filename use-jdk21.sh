#!/usr/bin/env bash
set -euo pipefail

# Script helper para usar un JDK local (colocar el tarball extraído en .jdk21/)
# - Busca el primer directorio dentro de .jdk21 y lo usa como JAVA_HOME
# - Muestra java -version, compila todos los .java y deja instrucciones para ejecutar

ROOT_DIR=$(pwd)
JDK_ROOT="$ROOT_DIR/.jdk21"

# Preferir una JDK 21 del sistema si está disponible
SYSTEM_JAVA=$(command -v java || true)
if [ -n "$SYSTEM_JAVA" ]; then
  SYS_VER=$($SYSTEM_JAVA -version 2>&1 | awk -F '"' 'NR==1{print $2}' || true)
  if [ -n "$SYS_VER" ] && [[ "$SYS_VER" == 21* ]]; then
    # usar la JDK del sistema
    JAVA_BIN=$(readlink -f "$SYSTEM_JAVA")
    JAVA_HOME=$(dirname $(dirname "$JAVA_BIN"))
    export JAVA_HOME
    export PATH="$JAVA_HOME/bin:$PATH"
    echo "Se detectó Java de sistema $SYS_VER. Usando JAVA_HOME=$JAVA_HOME"
  fi
fi

# Si no se estableció JAVA_HOME aún, buscar en .jdk21 como antes
if [ -z "${JAVA_HOME:-}" ]; then
  if [ ! -d "$JDK_ROOT" ]; then
    echo "No existe el directorio $JDK_ROOT. Descargue y extraiga un JDK 21 aquí (por ejemplo Temurin/Corretto)."
    echo "Ejemplo: mkdir -p $JDK_ROOT && tar -xzf OpenJDK21U-...tar.gz -C $JDK_ROOT"
    exit 1
  fi

  JDK_DIR=$(find "$JDK_ROOT" -maxdepth 1 -type d \! -path "$JDK_ROOT" | head -n 1 || true)
  if [ -z "$JDK_DIR" ]; then
    echo "No se encontró ningún JDK dentro de $JDK_ROOT. Asegúrese de extraer el tarball dentro de $JDK_ROOT/."
    exit 1
  fi

  export JAVA_HOME="$JDK_DIR"
  export PATH="$JAVA_HOME/bin:$PATH"
  echo "Usando JAVA_HOME=$JAVA_HOME (desde $JDK_ROOT)"
fi

echo "Usando JAVA_HOME=$JAVA_HOME"
echo
"$JAVA_HOME/bin/java" -version

echo
echo "Compilando todos los .java en el directorio actual..."
"$JAVA_HOME/bin/javac" -d out -cp . *.java

if [ $? -eq 0 ]; then
  echo
  echo "Compilación finalizada. Los .class están en ./out"
  echo "Para ejecutar una clase principal (por ejemplo Modelo_EOQ_Clasico):"
  echo "  \$JAVA_HOME/bin/java -cp out Modelo_EOQ_Clasico"
else
  echo "La compilación falló. Revisa los errores arriba." >&2
  exit 1
fi
