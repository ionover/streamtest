#!/bin/bash
# Quick run script for Java Stream Training

if [ -z "$1" ]; then
    echo "Usage: ./run.sh <TrainingClassName>"
    echo "Example: ./run.sh TrainingB2"
    echo ""
    echo "Available classes:"
    echo "  TrainingB2, TrainingB3, TrainingB4, TrainingB5, TrainingB6"
    echo "  TrainingB7, TrainingB8, TrainingB9"
    echo "  TrainingC1, TrainingC2, TrainingC3, TrainingC4"
    exit 1
fi

# Compile
echo "🔨 Compiling..."
mkdir -p bin
javac -d bin -sourcepath src $(find src -name "*.java") 2>&1

COMPILE_STATUS=$?

if [ $COMPILE_STATUS -eq 0 ]; then
    echo "✅ Compilation successful"
    echo ""
    echo "🧪 Running $1..."
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    java -cp bin com.orcun.streamtraining.training.$1
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
else
    echo "❌ Compilation failed"
    exit 1
fi
