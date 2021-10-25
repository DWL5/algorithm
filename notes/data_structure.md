# 자료구조

### 정의
- 자료구조란 자료를 컴퓨터의 기억장치 내에 저장하는 방법으로 자료를 효율적으로 표현하고 활용할 수 있도록 자료의 특성과 사용 용도를 고려하여 조직적, 체계적으로 정의한 것

### 분류
- 자료구조는 크게 선형구조와 비선형구조로 나눌 수 있다. 선형구조는 자료가 일렬로 연결되어 있는 형태로 구성하는 방법이고, 비선형구조는 자료의 구성이 계층구조나 망구조의 특별한 형태를 띠는 구조이다.

- 선형구조
  - 배열, 선형리스트, 연결리스트, 스택, 큐, 데크
- 비선형구조
  - 트리, 그래프

### 스택
- 선형리스트의 하나로 데이터가 입력된 순서로 기억공간에 저장되어 출력 시 가장 나중에 쌓인 데이터가 가장 먼저 출력을 하게되는 자료구조. (후입선출)

### 큐
- 가장 먼저 삽입한 원소는 맨앞에 있다가 가장 먼저 삭제 된다. (선입선출)
- 큐는 뒤에서만 삽입되고 앞에서는 삭제만 할 수 있는 구조
- 데이터가 삽입되는 곳과 삭제되는 곳이 다름

### 트리
- 원소들 간에 계층관계를 가지는 계층형 자료 구조로 상위원소에서 하위원소로 내려가면서 확장되는 나무 모양의 구조를 가지고 있다.
- 트리의 시작노드를 `루트노드` 노드를 연결하는 선을 `간선`이라고 한다.
- 같은 부모노드를 가진 자식노드들을 `형제노드`라고 하고 부모노드와 연결된 간선을 끊었을 때 생성되는 트리를 `서브트리`라고 한다.

### 그래프
- 연결되어 있는 원소 사이의 다:다 관계를 표현하는 자료구조로 객체를 나타내는 정점과 객체를 연결하는 간선의 집합이다.
