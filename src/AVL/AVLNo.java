package AVL;

/**
 *
 * @author RAFMo
 **/
class AVLNo {
    int chave, altura;
    AVLNo esquerda;
    AVLNo direita;

    public AVLNo(int chave) {
        this.chave = chave;
        esquerda = direita = null;
        altura = 1;
    }
}
  