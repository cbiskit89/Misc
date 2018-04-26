package kata

func Ann(n int) []int {
    list, _ := BuildLists(n)
    return (list)
}
func John(n int) []int {
    _, list := BuildLists(n)
    return (list)
}
func BuildLists(n int) ([]int, []int) {
  john := make([]int, n)
  ann := make([]int, n)
  john[0] = 0
  ann[0] = 1
  for i := 1; i < n; i++ {
      annLookback := ann[i - 1]
      johnLookback := john[i -1]
      john[i] = i - ann[johnLookback]
      ann[i] = i - john[annLookback]
    }
    return ann, john
}
func SumJohn(n int) (sum int) {
    var list = John(n)
    sum = 0
    for _, element := range list {
      sum += element
    }
    return
}
func SumAnn(n int) (sum int) {
    var list = Ann(n)
    sum = 0
    for _, element := range list {
      sum += element
    }
    return
}
