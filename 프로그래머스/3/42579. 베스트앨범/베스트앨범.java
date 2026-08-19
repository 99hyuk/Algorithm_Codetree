import java.util.*;

class Music implements Comparable<Music>{
    String genre;
    int totalPlay;
    
    Music(String genre, int totalPlay) {
        this.genre = genre;
        this.totalPlay = totalPlay;
    }
    
    @Override
    public int compareTo(Music o) {
        return Integer.compare(o.totalPlay, this.totalPlay);
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> mapCount = new HashMap<>();
        int n = genres.length;
        for (int i=0; i<n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            mapCount.put(genres[i], mapCount.getOrDefault(genres[i], 0) + 1);
        }
        
        List<Music> list = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Music(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(list);
        
        List<Integer> result = new ArrayList<>();
        
        for (Music music : list) {
            String genre = music.genre;

            if (mapCount.get(genre) == 1) {
                for (int i=0; i<n; i++) {
                    if (!genre.equals(genres[i])) continue;
                    result.add(i);
                }
                continue;
            }
            
            int first_index = 0;
            int first_value = 0;
            int second_index = 0;
            int second_value = 0;
            
            for (int i=0; i<n; i++) {
                if (!genre.equals(genres[i])) continue;
                int value = plays[i];
                
                if (first_value < value) {
                    second_index = first_index;
                    second_value = first_value;

                    first_index = i;
                    first_value = value;

                } else if (second_value < value) {
                    second_index = i;
                    second_value = value;
                }
            }
            
            result.add(first_index);
            result.add(second_index);
        }
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}