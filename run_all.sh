#!/bin/bash
# Run all training tests

echo "🔨 Compiling all files..."
mkdir -p bin
javac -d bin -sourcepath src $(find src -name "*.java") 2>&1

COMPILE_STATUS=$?

if [ $COMPILE_STATUS -ne 0 ]; then
    echo "❌ Compilation failed"
    exit 1
fi

echo "✅ Compilation successful"
echo ""

# List of all training classes
classes=(
    "TrainingB2"
    "TrainingB3"
    "TrainingB4"
    "TrainingB5"
    "TrainingB6"
    "TrainingB7"
    "TrainingB8"
    "TrainingB9"
    "TrainingC1"
    "TrainingC2"
    "TrainingC3"
    "TrainingC4"
)

passed=0
failed=0

echo "🧪 Running all tests..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

for class in "${classes[@]}"; do
    echo ""
    echo "📋 $class:"
    result=$(java -cp bin com.orcun.streamtraining.training.$class 2>&1)
    echo "$result"
    
    if echo "$result" | grep -q "✓ Test passed!"; then
        ((passed++))
    else
        ((failed++))
    fi
done

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo "📊 Summary:"
echo "   ✅ Passed: $passed / ${#classes[@]}"
echo "   ❌ Failed: $failed / ${#classes[@]}"
echo ""

if [ $failed -eq 0 ]; then
    echo "🎉 Поздравляем! Все тесты пройдены!"
else
    echo "💪 Продолжайте решать задачи!"
fi
