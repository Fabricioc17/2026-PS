catalogo = [
    {"titulo": "O Programador Pragmático", "autor": "Andrew Hunt", "disponivel": True},
    {"titulo": "Codigo Limpo", "autor": "Robert C. Martin", "disponivel": False},
    {"titulo": "Padrões de Projeto", "autor": "Erich Gamma", "disponivel": True},
]

def listar_livros():
    print("\n" + "-" * 50)
    print("📚 CATÁLOGO DA BIBLIOTECA")
    print("=" * 50)

    if not catalogo:
        print("Nenhum livro cadastrado.")
        return
    
    for i, livro in enumerate(catalogo, 1):
        status = "Disponivel" if livro["disponivel"] else "Emprestado"
        print(f"{i}. {livro['titulo']} - {livro['autor']} [{status}]")

    print("-" * 50)


def adicionar_livros():
    print("\n--- Adicionar Novo Livro ---")

    titulo = input("Titulo: ").strip()
    autor = input("Autor: ").strip()

    if not titulo or not autor:
        print("Titulo e autor são obrigatórios")
        return
    
    catalogo.append({
        "titulo": titulo,
        "autor": autor,
        "disponivel": True
    })

    print(f"'{titulo}' adicionado com sucesso!")


def buscar_livro():
    print("\n--- Buscar Livro ---")
    termo = input("Digite parte do título: ").strip().lower()

    try:
        resultados = [i for i in catalogo if termo in i["titulo"].lower()]

        if not resultados:
            print("Nenhum livro encontrado.")
            return

        print(f"\n{len(resultados)} resultado(s):")
        for livro in resultados:
            status = "Disponivel" if livro["disponivel"] else "Emprestado"
            print(f"{livro['titulo']} - {livro['autor']} [{status}]")

    except Exception as e:
        print("Erro Inesperado:", e)

def registrar_emprestimo():
    listar_livros()
    if not catalogo:
        return
    print("\n--- REGISTRAR EMPRÉSTIMO----")

    try:

        numero=int(input("Numero do livro: ")) # Value error ae digitar
        if numero < 1 or numero > len (catalogo) :
            print(" Numero fora do intervalo.")
            return
        
        livro = catalogo[numero-1] # -1 pq a lista começa em 0
        if not livro []