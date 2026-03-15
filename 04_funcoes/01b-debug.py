# Arquivo: 01b-debug.py

# 1 Adiciondo return para a mensagem
def saudacao(nome, turno="manhã"):
    mensagem = f"Bom {turno}, {nome}!"
    return mensagem  
print(saudacao("Ana"))
print(saudacao("Bruno", "tarde"))


# 2 Adicionado return para o cálculo 
def dobrar(x):
    resultado = x * 2
    return resultado   

print("Dobro de 5:", dobrar(5))


#3 Uso da palavra-chave global
total = 0
def incrementar():
    global total     
    total = total + 1

incrementar()
print("Total:", total)


# 4 Adicionado Caso Base na Recursão
def contagem(n):
    if n < 0:         
        return
    print(n)
    contagem(n - 1)

contagem(3)