; ModuleID = 'SSA.cpp'
source_filename = "SSA.cpp"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.23.28106"

; Function Attrs: noinline norecurse nounwind optnone uwtable
define dso_local i32 @main() #0 {
entry:
  %m = alloca i32, align 4
  %n = alloca i32, align 4
  %c = alloca i32, align 4
  %x = alloca i32*, align 8
  store i32 10, i32* %m, align 4
  store i32 10, i32* %n, align 4
  %0 = load i32, i32* %m, align 4
  %1 = load i32, i32* %n, align 4
  %add = add nsw i32 %0, %1
  store i32 %add, i32* %m, align 4
  %2 = load i32, i32* %m, align 4
  %sub = sub nsw i32 %2, 10
  store i32 %sub, i32* %m, align 4
  store i32 10, i32* %c, align 4
  store i32* %c, i32** %x, align 8
  %3 = load i32*, i32** %x, align 8
  store i32 100, i32* %3, align 4
  ret i32 0
}

attributes #0 = { noinline norecurse nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.linker.options = !{!0, !1, !2, !3, !4}
!llvm.module.flags = !{!5, !6}
!llvm.ident = !{!7}

!0 = !{!"/FAILIFMISMATCH:\22_MSC_VER=1900\22"}
!1 = !{!"/FAILIFMISMATCH:\22_ITERATOR_DEBUG_LEVEL=0\22"}
!2 = !{!"/FAILIFMISMATCH:\22RuntimeLibrary=MT_StaticRelease\22"}
!3 = !{!"/DEFAULTLIB:libcpmt.lib"}
!4 = !{!"/FAILIFMISMATCH:\22_CRT_STDIO_ISO_WIDE_SPECIFIERS=0\22"}
!5 = !{i32 1, !"wchar_size", i32 2}
!6 = !{i32 7, !"PIC Level", i32 2}
!7 = !{!"clang version 10.0.0 (trunk 375216) (llvm/trunk 375210)"}
