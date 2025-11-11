//BUBBLESORT
for (int j = 0, i < array.length - 1; j++){
    for (i = 0; i < array.length -1 -j; i++){
        if(array[1] > array[i+1]){
            swap(i, i+1);
        }
    }
}

//SELECTIONSORT
for (int j = 0, i < array.length - 1; j++){
    int menorIndex = 0;
    for (int i = 1 + j; i < array.length; i++){
        if (array[menorIndex] > array[i]){
            menorIndex = i;
        }
        swap(j, menorIndex);
    }
}

//INSERTIONSORT



public void swap(int a, int b){
    int temp = array[a];

}