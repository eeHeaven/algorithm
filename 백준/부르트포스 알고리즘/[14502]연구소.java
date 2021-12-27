public static void BFS(){
  
  int[][] virus_map = new int[N][M];
  Queue<virus> que = new LinkedList<virus>();
  
  //virus map 카피
  for(int i = 0; i<N;i++){
    for(int j = 0; j<M;j++){
      virus_map[i][j] = map[i][j];
    }
  }
}

for(int i = 0; i<N;i++)
  for(int j = 0;j<M;j++)
    //바이러스면 큐에 넣기
    if(virus_map[i][j] == VIRUS) que.add(new virus(i,j));

while(!que.isEmpty()){
 
  virus v = que.remove();
  for(int d = 0; d<4;d++){
    int nr = v.x +dr[d];
    int nc = v.y +dc[d]; // 사방 탐색 
    
    //범위 안에 있으면
    if(nr>=0 && nc>=0 && nr<N && nc<M){
    //빈칸이라면 바이러스 퍼뜨리고 다시 그자리의 바이러스 큐에 넣기
      if(virus_map[nr][nc] == EMPTY){
      virus_map[nr][nc] = VIRUS;
        que.add(new virus(nr,nc));
      }
    
    }
}
