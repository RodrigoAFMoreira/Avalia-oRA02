package AVL;

/**
 *
 * @author RAFMo
 **/
import java.util.Random;

public class AVLTeste {

    public static void main(String[] args) {
        AVLArvore avlArvo = new AVLArvore();

         Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomNum = random.nextInt(40000); 
            avlArvo.inserir(randomNum);
        }

        System.out.print("In-Ordem: ");
        avlArvo.inOrdem();
        System.out.println();
        
        int elementoProcurar = 1;
        boolean elementoEncontrado = avlArvo.procurar(elementoProcurar);
        System.out.println("Elemento " + elementoProcurar + ": " + (elementoEncontrado ? "Encontrado" : "Não Encontrado"));
        
        int elementoRemove = 30;
        avlArvo.remover(elementoRemove);

        boolean ElementoArvoree = avlArvo.procurar(elementoRemove);
        System.out.println("Elemento removid " + elementoRemove + ": " + (ElementoArvoree ? "Encontrado" : "Nao Encontrado"));
        System.out.print("In-Ordem: ");
        avlArvo.inOrdem();
        System.out.println();
        System.out.println("AVL");
    }
}
  