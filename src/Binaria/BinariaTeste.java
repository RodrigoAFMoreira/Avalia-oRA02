package Binaria;

/**
 *
 * @author RAFMo
**/
import java.util.Random;

public class BinariaTeste {

    public static void main(String[] args) {
        BinariaArvore binariaArvo = new BinariaArvore();

        
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            int randomNumber = random.nextInt(40000); 
            binariaArvo.inserir(randomNumber);
        }

        System.out.print("In-Ordem: ");
        binariaArvo.inOrdem();
        System.out.println();
        
        int elementoProcurar = 1;
        boolean elementoEncontrado = binariaArvo.procurar(elementoProcurar);
        System.out.println("Elemento " + elementoProcurar + ": " + (elementoEncontrado ? "Encontrado" : "Não Encontrado"));
        
        int elementoRemove = 30;
        binariaArvo.remover(elementoRemove);

        boolean ElementoArv = binariaArvo.procurar(elementoRemove);
        System.out.println("elemento removido " + elementoRemove + ": " + (ElementoArv ? "Encontrado" : "Não Encontrado"));

        
        System.out.print("In-Ordem: ");
        binariaArvo.inOrdem();
        System.out.println();
        
        System.out.println("Binario");
    }
}
