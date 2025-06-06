# [Gold IV] 구슬게임 - 2600 

[문제 링크](https://www.acmicpc.net/problem/2600) 

### 성능 요약

메모리: 17604 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍, 게임 이론

### 제출 일자

2025년 6월 4일 01:01:57

### 문제 설명

<p>두 사람 A와 B가 번갈아 가면서 두 개의 구슬 통에서 몇 개씩의 구슬을 꺼내는 게임을 한다.</p>

<p>한번에 한 사람이 한 통에서 꺼낼 수 있는 구슬의 개수는 세 가지 뿐이다. 그리고 구슬을 꺼낼 경우 두 개의 구슬 통 중에서 하나를 마음대로 선택해서 그 안에서만 꺼낼 수 있다. 즉 두 개의 통 모두에서 동시에 몇 개씩 꺼낼 수는 없다.</p>

<p>게임은 항상 A가 먼저하고 그 다음 B, 그 다음 A 순으로 번갈아가면서 진행된다. 그리고 자신의 차례가 되었을 때에 정해진 규칙대로 구슬을 꺼낼 수 없는 사람이 게임에서 지게 되고, 상대방은 승리하게 된다.</p>

<p>예를 들어 한번에 꺼낼 수 있는 구슬의 개수를 1개, 3개, 또는 4개라고 하자. 만일 두 개의 구슬 통에 각각 4개, 1개의 구슬이 있다고 하면 처음 선택을 하게 되는 A가 이긴다. 그러나 만일 두 통속의 구슬이 각각 5개, 5개라면 B가 이긴다.</p>

<p>즉 한번에 꺼낼 수 있는 구슬 개수인 b<sub>1</sub>, b<sub>2</sub>, b<sub>3</sub>가 주어지고, 두 구슬 통 속에 들어있는 구슬의 수인 k<sub>1</sub>, k<sub>2</sub>이 정해지면, 이러한 b<sub>1</sub>, b<sub>2</sub>, b<sub>3</sub>와 k<sub>1</sub>, k<sub>2</sub>에 따라서 승패는 결정된다. 문제는 주어진 b<sub>1</sub>, b<sub>2</sub>, b<sub>3</sub>와 k<sub>1</sub>, k<sub>2</sub>에 대하여 A, B중 누가 승자인지를 결정하는 것이다.</p>

<p>처음 두 통 속에 들어 있는 구슬의 수 k<sub>1</sub>, k<sub>2</sub>와 한 번에 꺼낼 수 있는 구슬의 수 b<sub>1</sub>, b<sub>2</sub>, b<sub>3</sub>에 대한 제한조건은 다음과 같다.</p>

<ul>
	<li>1 ≤ b<sub>1</sub> < b<sub>2</sub> < b<sub>3</sub> ≤ 30 </li>
	<li>1 ≤ k<sub>1</sub>, k<sub>2</sub> ≤500</li>
</ul>

### 입력 

 <p>첫 줄에는 한번에 꺼낼 수 있는 구슬의 개수를 나타내는 세 개의 정수 b<sub>1</sub>, b<sub>2</sub>, b<sub>3</sub> 가 나타난다. 그 다음 5개의 각 줄에는 두 통속에 처음 담겨있는 구슬의 개수 k<sub>1</sub>, k<sub>2</sub>가 각각 표시되어 있다.</p>

### 출력 

 <p>각 5개의 k<sub>1</sub>, k<sub>2</sub> 경우에 대하여 그에 대응되는 승자(A 또는 B)를 각각 한 줄에 하나씩 차례대로 다섯 개를 출력해야 한다.</p>

