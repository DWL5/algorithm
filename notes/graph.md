# 그래프
- 정점(vertex)와 간선(edge)로 이루어진 자료구조
- 사이클 : 시작한 정점에서 끝나느경로

![image](https://user-images.githubusercontent.com/18106839/136319218-c95f4d19-92f4-4209-916f-4a96add4c7cc.png)

## 최단경로
- 경로 : 간선들을 순서대로 나열한 것
- 최단 경로: 시작 정점에서 목표 정점까지 가는 간선의 **가중치**의 합이 최소가 되는 경로

<br/>

- 단일 출발(single-source) 최단 경로:
  - 단일 노드 V에서 출발하여 그래프 내의 모든 다른 노드에 도착하는 최단 경로
- 단일 도착 (single-destination) 최단 경로:
  - 모든 노드들로부터 출발하여 그래프 내의 한 단일 노트 v로 도착하는 최단 경로
- 단일 쌍(single-pair) 최단 경로:
  - 주어진 꼭지점 u와 v에 대해 u에서 v까지의 최단 경로
- 전체 쌍(all-pair) 최단 경로:
  - 그래프 내 모든 노드 쌍들 사이의 최단 경로

## 다익스트라 알고리즘
- **양의 가중치**를 가진 최단 경로 탐색에 사용하는 알고리즘
- 최단 경로의 **부분 경로는 최단경로** 이다.

## 최소 신장 트리
- 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소인 신장트리
- 신장 트리(Spanning Tree)
  - n개의 정점을 포함하는 무향 그래프에서 n개의 정점과 n-1개의 간선으로 구성된 트리

![image](https://user-images.githubusercontent.com/18106839/136320973-43f08bc6-5691-49f8-8abb-3743655993e1.png)

### 프림 알고리즘
- 임의의 정점과 인접한 정점 중에서 최소 비용 간선을 선택하면서 최소 신장 트리를 만들어가는 알고리즘
- 정점이 적고, 간선이 많을 때 유리한 알고리즘

### 크루스칼 알고리즘
- 가중치가 적은 간선을 하나씩 선택해서 최소 신장 트리를 찾는 알고리즘
- 희소 그래프일 때 더 효율적이다.
