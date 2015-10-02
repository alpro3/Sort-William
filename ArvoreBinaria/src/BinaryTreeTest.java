
//FIXME: IMPORTAR JUNIT

public class BinaryTreeTest {

	//@Test
	public void testArvoreVazia() {
		BinaryTree arvore = new BinaryTree();
		String expected = "BinaryTree [raiz= # ]";
		String actual = arvore.toString();
		assertEquals("Falha ao consultar a Árvore vazia!", expected, actual);;
	}

	//@Test(expected=IllegalArgumentException.class)
	public void testInserirComDuplicata() {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(42);
		arvore.inserir(42);
	}
	
	//@Test
	public void testArvoreComDoisNodos() {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(42);
		arvore.inserir(46);
		String expected = "BinaryTree [raiz= 42 [ # ][ 46 [ # ][ # ]]]";
		String actual = arvore.toString();
		assertEquals("Falha na estrutura daÁrvore!", expected, actual);;
	}
	
	//@Test
	public void testConsultarArvoreVazia() {
		BinaryTree arvore = new BinaryTree();
		boolean expected = false;
		boolean actual = arvore.consultar(42);
		assertEquals("Falha ao consultar chave na �rvore vazia!", expected, actual);;
	}

	//@Test
	public void testConsultarArvoreUnitaria() {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(42);
		boolean expected = true;
		boolean actual = arvore.consultar(42);
		assertEquals("Falha ao consultar chave na �rvore vazia!", expected, actual);;
	}
}