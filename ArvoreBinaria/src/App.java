public class App {
	public static void main(String[] args) {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(10);
		arvore.inserir(5);
		arvore.inserir(9);
		arvore.inserir(20);
		arvore.inserir(32);
		arvore.inserir(12);
		arvore.inserir(31);
		System.out.println(arvore.toString());
	}
}
