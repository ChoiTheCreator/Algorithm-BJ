function solution(my_string) {
  var answer = 0;
  const parsedArr = [...my_string];
  console.log(parsedArr);
  parsedArr.forEach((element) => {
    if (!isNaN(element)) {
      answer += parseFloat(element);
    }
  });
  return answer;
}