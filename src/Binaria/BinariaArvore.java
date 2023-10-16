package Binaria;

/**
 *
 * @author RAFMo
 **/
class BinariaArvore {
    BinariaNo raiz;

    public BinariaArvore() {
        raiz = null;
    }

    public void inserir(int chave) {
        raiz = inserirRecursivo(raiz, chave);
    }

    public boolean procurar(int chave) {
        return procurarRecursivo(raiz, chave);
    }

    public void remover(int chave) {
        raiz = removerRecursivo(raiz, chave);
    }

    public void inOrdem() {
        inOrdemRecursivo(raiz);
    }

    private BinariaNo inserirRecursivo(BinariaNo raiz, int chave) {
        if (raiz == null) {
            return new BinariaNo(chave);
        }

        if (chave < raiz.chave) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, chave);
        } else if (chave > raiz.chave) {
            raiz.direita = inserirRecursivo(raiz.direita, chave);
        }

        return raiz;
    }

    private boolean procurarRecursivo(BinariaNo root, int chave) {
        if (root == null) {
            return false;
        }

        if (chave == root.chave) {
            return true;
        }

        if (chave < root.chave) {
            return procurarRecursivo(root.esquerda, chave);
        } else {
            return procurarRecursivo(root.direita, chave);
        }
    }
    
    private int minValor(BinariaNo no) {
        int minValor = no.chave;
        while (no.esquerda != null) {
            minValor = no.esquerda.chave;
            no = no.esquerda;
        }
        return minValor;
    }

     private void inOrdemRecursivo(BinariaNo no) {
        if (no != null) {
            inOrdemRecursivo(no.esquerda);
            System.out.print(no.chave + " ");
            inOrdemRecursivo(no.direita);
        }
    }

    private BinariaNo removerRecursivo(BinariaNo root, int chave) {
        if (root == null) {
            return root;
        }

        if (chave < root.chave) {
            root.esquerda = removerRecursivo(root.esquerda, chave);
        } else if (chave > root.chave) {
            root.direita = removerRecursivo(root.direita, chave);
        } else {
            if (root.esquerda == null) {
                return root.direita;
            } else if (root.direita == null) {//
                return root.direita;
            }

            root.chave = minValor(root.direita);

            root.direita = removerRecursivo(root.direita, root.chave);
        }
           
        return root;
    }
    
}
