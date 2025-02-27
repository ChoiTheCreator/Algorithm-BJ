
function solution(my_stirng) {
  var answer = 0;
  var numStr = '';
  const parsedArr = [...my_stirng];
  const length = parsedArr.length;

  for (let i = 0; i < length; i++) {
    if (!isNaN(parsedArr[i]) ) {
      numStr += parsedArr[i];
    }
    
    else if (isNaN(parsedArr[i]) && numStr != '' && parseFloat(numStr) != 0) {
      answer += parseFloat(numStr);
      numStr = '';
    }
  }
    
    if(numStr != ''){
        answer += parseFloat(numStr);
    }

  return answer;
}