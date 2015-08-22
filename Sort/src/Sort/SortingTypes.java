/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author 14201805
 */
public class SortingTypes {

    public void bubble_sort(int[] v) {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    int a=v[i];
                    v[i]=v[i+1];
                    v[i+1]=a;
                    trocou = true;
                }
            }
        }
    }

    public void insertion_sort(int[] v) {
        int i, j, chave;
        for (j = 1; j < v.length; j++) {
            chave = v[j];
            i = j - 1;
            while ((i >= 0) && (v[i] > chave)) {
                v[i + 1] = v[i];
                i=i+1;
}
v[i + 1] = chave;
        }
    }

    public void merge_sort(int[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            merge_sort(v, inicio, meio);
            merge_sort(v, meio + 1, fim);
            merge(v, inicio, meio, fim);
        }
    }

    private void merge(int[] v, int inicio, int meio, int fim) {
        int nL = meio - inicio + 1;
        int nR = fim - meio;
        int[] L = new int[nL];
        int[] R = new int[nR];
        System.arraycopy(v, inicio, L, 0, nL);
        System.arraycopy(v, meio + 1, R, 0, nR);
        int iL = 0;
        int iR = 0;
        for (int k = inicio; k <= fim; k++) {
            if (iR < nR) {
                if (iL < nL) {
                    if (L[iL] < R[iR]) {
                        v[k] = L[iL++];
                    } else {
                        v[k] = R[iR++];
                    }
                } else {
                    v[k] = R[iR++];
                }
            } else {
                v[k] = L[iL++];
            }
        }
    }

}
