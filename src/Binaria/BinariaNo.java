package Binaria;

/**
 *
 * @author RAFMo
**/
class BinariaNo {
    int chave;
    BinariaNo esquerda;
    BinariaNo direita;

    public BinariaNo(int chave) {
        this.chave = chave;
        esquerda = direita = null;
    }
}
