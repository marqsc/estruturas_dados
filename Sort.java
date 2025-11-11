//BUBBLESORT
for (int j = 0, i < array.length - 1; j++){
    for (i = 0; i < array.length -1 -j; i++){
        if(array[1] > array[i+1]){
            swap(i, i+1);
        }
    }
}

//SELECTIONSORT
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = temp;
        }


//INSERTIONSORT
for (int j = 0, i < array.length - 1; j++){
    int menorIndex = 0;
    for (int i = 1 + j; i < array.length; i++){
        if (array[menorIndex] > array[i]){
            menorIndex = i;
        }
        swap(j, menorIndex);
    }
}


//SWAP
public static void swap(int[] vetor, int i, int j) {
    int temp = vetor[i];
    vetor[i] = vetor[j];
    vetor[j] = temp;
}
