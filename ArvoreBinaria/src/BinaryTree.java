
/**
 *
 * @author marco.mangan@pucrs.br
 *
 */
public class BinaryTree {

    private Nodo raiz;

    /**
     * Insere uma nova chave na árvore.
     *
     * Em caso de duplicatas, uma exceção é gerada.
     *
     * @param chave o valor da nova chave
     */
    private class Nodo {

        public int chave;

        public int altura;

        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(int chave) {
            this.chave = chave;
            altura = 0;
            esquerdo = direito = null;
        }
    }

    public void inserir(int chave) {
        raiz = inserir0(raiz, chave);
    }

    /**
     *
     * @param nodo
     * @param chave
     * @return
     */
    private Nodo inserir0(Nodo nodo, int chave) {
        if (nodo == null)
			return new Nodo(chave);

		if (chave < nodo.chave) {
			nodo.esquerdo = inserir0(nodo.esquerdo, chave);
			if (h(nodo.esquerdo) - h(nodo.direito) == 2) {
				if (chave < nodo.esquerdo.chave) {
					nodo = rotacionarComFilhoEsquerdo(nodo);
				} else {
					nodo = duplaComFilhoEsquerdo(nodo);
				}
			}
		} else if (chave > nodo.chave) {
			nodo.direito = inserir0(nodo.direito, chave);
			if (h(nodo.esquerdo) - h(nodo.direito) == -2) {
				if (chave > nodo.direito.chave) {
				nodo = rotacionarComFilhoDireito(nodo);
				} else {
					nodo = duplaComFilhoDireito(nodo);					
				}
			}
		} else
			throw new IllegalArgumentException("Chave duplicada");

		nodo.altura = Math.max(h(nodo.esquerdo), h(nodo.direito)) + 1;

		return nodo;
    }

    private int h(Nodo nodo) {

        return nodo == null ? -1 : nodo.altura;
    }

    @Override
    public String toString() {
        return String.format("ArvoreBinariaDePesquisa%n[raiz=%s]",
                toString0(raiz));
    }

    private String toString0(Nodo nodo) {
        if (nodo == null) {
            return " # ";
        }

        int delta = getAltura0(nodo.esquerdo) - getAltura0(nodo.direito);
        String msg = String
                .format("%d  nível= ? altura= %d delta= %d grau= %d pai= ? tio = ? %n[%s]%n[%s]",
                        nodo.chave, getAltura0(nodo), delta, grau(nodo),
                        toString0(nodo.esquerdo), toString0(nodo.direito));

        return msg;
    }

    private int grau(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }

        int g = 0;
        if (nodo.esquerdo != null) {
            g++;
        }
        if (nodo.direito != null) {
            g++;
        }

        return g++;
    }
    
    private Nodo duplaComFilhoDireito(Nodo k1) {
		k1.direito = rotacionarComFilhoEsquerdo(k1.direito);
		return rotacionarComFilhoDireito(k1);
	}

	private Nodo duplaComFilhoEsquerdo(Nodo k3) {
		k3.esquerdo = rotacionarComFilhoDireito(k3.esquerdo);
		return rotacionarComFilhoEsquerdo(k3);
	}

	private Nodo rotacionarComFilhoDireito(Nodo k1) {
		Nodo k2 = k1.direito;
		k1.direito = k2.esquerdo;
		k2.esquerdo = k1;

		k1.altura = Math.max(h(k1.esquerdo), h(k1.direito)) + 1;
		k2.altura = Math.max(k1.altura, h(k2.direito)) + 1;

		return k2;
	}

	private Nodo rotacionarComFilhoEsquerdo(Nodo k2) {
		Nodo k1 = k2.esquerdo;
		k2.esquerdo = k1.direito;
		k1.direito = k2;

		k2.altura = Math.max(h(k2.esquerdo), h(k2.direito)) + 1;
		k1.altura = Math.max(h(k1.esquerdo), k2.altura) + 1;

		return k1;
	}
    
   

    public boolean consultar(int chave) {
        return consultar0(raiz, chave);
    }

    private boolean consultar0(Nodo nodo, int chave) {
        if (nodo == null) {
            return false;
        }

        if (chave < nodo.chave) {
            return consultar0(nodo.esquerdo, chave);
        } else if (chave > nodo.chave) {
            return consultar0(nodo.direito, chave);
        } else {
            return true;
        }
    }

    public int getAltura() {
        return getAltura0(raiz);
    }

    private int getAltura0(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }

        return 1 + Math
                .max(getAltura0(nodo.esquerdo), getAltura0(nodo.direito));
    }

    public boolean isEquilibrada() {
        return isEquilibrada0(raiz);
    }

    private boolean isEquilibrada0(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        int delta = getAltura0(nodo.esquerdo) - getAltura0(nodo.direito);

        if (delta == 2 || delta == -2) {
            return false;
        }

        return isEquilibrada0(nodo.esquerdo)
                && isEquilibrada0(nodo.direito);
    }

}
