import java.util.Arrays;

public class ClownSort {
    public static void main(String[] args) {

        //int[] a = new int[] {50, 73, 73, 26, 20};
        int[] a = randomArray(5, 100, 0);
        System.out.println(Arrays.toString(a));

        while(!isOrdered(a)){
            a = randomSort(a);
        }

        System.out.println(Arrays.toString(a));
        
    }

    public static int[] randomSort(int[] a) {
        int[] ordenado = new int[a.length];
        int[] orden = randomUniqueArray(a.length);

        System.out.println(Arrays.toString(orden));

        for(int i = 0; i < a.length; i++){
            ordenado[i] = a[orden[i]];
        }
        return ordenado;
    }
    
    public static int[] randomArray(int l, int max, int min) {
        int[] array = new int[l];
        
        for(int i = 0; i < l; i++) {
            array[i] =  (int) (Math.random()*(max-min+1)+min);
        }

        return array;
    }

    public static int[] randomUniqueArray(int l) {
        int[] array = new int[l];
        for(int i = 0; i < l; i++) {
            array[i] = -1;
        }
        int i = 0;
        while(i < l){
            int candidato = (int) (Math.random()*l);
            if(!numInArray(candidato, array)){
                array[i] = candidato;
                i++;
            }
        }
        return array;
    }

    public static boolean numInArray(int n, int[] a) {
        for(int i = 0; i < a.length; i++){
            if(a[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOrdered(int[] a) {
        for(int i = 0; i < a.length-1; i++) {
            if(a[i] < a[i+1]){
                return false;
            }
        }
        return true;
    }
}
