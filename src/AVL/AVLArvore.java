package AVL;

/**
 *
 * @author RAFMo
 **/
class AVLArvore {
    AVLNo raiz;

    public AVLArvore() {
        raiz = null;
    }

    public void inserir(int chave) {
        raiz = inserirRecursivo(raiz, chave);
    }

    private int altura(AVLNo no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int max(int z, int w) {
        return (z > w) ? z : w;
    }

    private AVLNo rotacaoEsquerda(AVLNo x) {
        AVLNo y = x.direita;
        AVLNo T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }
    
    private AVLNo rotacaoDireita(AVLNo y) {
        AVLNo x = y.esquerda;
        AVLNo T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private int getBalanca(AVLNo no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    private AVLNo inserirRecursivo(AVLNo no, int chave) {
        if (no == null) {
            return new AVLNo(chave);
        }

        if (chave < no.chave) {
            no.esquerda = inserirRecursivo(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserirRecursivo(no.direita, chave);
        } else {
            return no;
        }

        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        int balance = getBalanca(no);

        if (balance > 1 && chave < no.esquerda.chave) {
            return rotacaoDireita(no);
        }

        if (balance > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && chave > no.direita.chave) {
            return rotacaoEsquerda(no);
        }

        if (balance < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public boolean procurar(int chave) {
        return procurarRecursivo(raiz, chave);
    }

    private boolean procurarRecursivo(AVLNo no, int chave) {
        if (no == null) {
            return false;
        }

        if (chave == no.chave) {
            return true;
        }

        if (chave < no.chave) {
            return procurarRecursivo(no.esquerda, chave);
        } else {
            return procurarRecursivo(no.direita, chave);
        }
    }
    
    private AVLNo minValorNo(AVLNo no) {
        AVLNo atual = no;

        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual;
    }
    
    public void inOrdem() {
            inOrdemRecursivo(raiz);
        }

    private void inOrdemRecursivo(AVLNo no) {
        if (no != null) {
            inOrdemRecursivo(no.esquerda);
            System.out.print(no.chave + " ");
            inOrdemRecursivo(no.direita);
        }
    }

    public void remover(int chave) {
        raiz = removeRecursivo(raiz, chave);
    }

    

    private AVLNo removeRecursivo(AVLNo no, int chave) {
        if (no == null) {
            return no;
        }

        if (chave < no.chave) {
            no.esquerda = removeRecursivo(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = removeRecursivo(no.direita, chave);
        } else {
            if (no.esquerda == null || no.direita == null) {
                AVLNo temp = (no.esquerda != null) ? no.esquerda : no.direita;

                if (temp == null) {
                    temp = no;
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                AVLNo temp = minValorNo(no.direita);

                no.chave = temp.chave;
                no.direita = removeRecursivo(no.direita, temp.chave);
            }
        }

        if (no == null) {
            return no;
        }

        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        int balanca = getBalanca(no);

        if (balanca > 1 && getBalanca(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }

        if (balanca > 1 && getBalanca(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanca < -1 && getBalanca(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (balanca < -1 && getBalanca(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

}
