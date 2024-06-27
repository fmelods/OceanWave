# Dicionários para simular tabelas de banco de dados
areas_monitoradas = {
    1: {'id_ong': 1, 'nome': 'Área Costeira', 'descricao': 'Área monitorada costeira', 'coordenadas': '123,456'},
    2: {'id_ong': 2, 'nome': 'Área Oceânica', 'descricao': 'Área monitorada oceânica', 'coordenadas': '789,012'}
}

sensores = {
    1: {'id_area': 1, 'localizacao': 'Praia', 'tipo': 'Temperatura', 'status': 'Ativo', 'dt_instalacao': '2024-01-01'},
    2: {'id_area': 2, 'localizacao': 'Mar Aberto', 'tipo': 'pH', 'status': 'Ativo', 'dt_instalacao': '2024-02-01'}
}

medicoes = {
    1: {'id_sensor': 1, 'temperatura': 25.5, 'ph': 7.8, 'oxigenio_dissolvido': 5.4, 'plastico': 2.1, 'outras_substancias': 'Nenhuma'},
    2: {'id_sensor': 2, 'temperatura': 20.0, 'ph': 8.0, 'oxigenio_dissolvido': 6.0, 'plastico': 1.5, 'outras_substancias': 'Baixa'}
}

alertas = {
    1: {'id_medicao': 1, 'tipo_alerta': 'Alto Nível de Plástico', 'status': 'Ativo', 'data_hora': '2024-05-01 10:00'},
    2: {'id_medicao': 2, 'tipo_alerta': 'pH Fora do Padrão', 'status': 'Ativo', 'data_hora': '2024-05-02 11:00'}
}

acoes = {
    1: {'id_alerta': 1, 'nome': 'Limpeza Costeira', 'descricao': 'Limpeza da área costeira', 'status': 'Planejado', 'dt_inicio': '2024-06-01', 'dt_fim': '2024-06-02'},
    2: {'id_alerta': 2, 'nome': 'Verificação de pH', 'descricao': 'Verificação e correção dos níveis de pH', 'status': 'Em andamento', 'dt_inicio': '2024-06-03', 'dt_fim': '2024-06-04'}
}

ongs = {
    1: {'nome': 'ONG Marinha', 'endereco': 'Rua das Ondas, 123', 'email': 'contato@ongmarinha.org', 'telefone': '1234-5678', 'responsavel': 'João Silva'},
    2: {'nome': 'ONG Oceânica', 'endereco': 'Avenida do Mar, 456', 'email': 'contato@ongoceanica.org', 'telefone': '9876-5432', 'responsavel': 'Maria Souza'}
}

# Função para validar a entrada do usuário
def validar_entrada(mensagem, tipo):
    while True:
        entrada_usuario = input(mensagem)
        try:
            if tipo == int:
                return int(entrada_usuario)
            elif tipo == float:
                return float(entrada_usuario)
            else:
                return str(entrada_usuario)
        except ValueError:
            print("Entrada inválida. Por favor, insira um valor válido.")

# Função para adicionar área
def adicionar_area():
    id_area = validar_entrada("Digite o ID da área: ", int)
    id_ong = validar_entrada("Digite o ID da ONG: ", int)
    if id_ong not in ongs:
        print("ONG não encontrada.")
        return
    nome = validar_entrada("Digite o nome da área: ", str)
    descricao = validar_entrada("Digite a descrição da área: ", str)
    coordenadas = validar_entrada("Digite as coordenadas da área: ", str)
    areas_monitoradas[id_area] = {
        'id_ong': id_ong,
        'nome': nome,
        'descricao': descricao,
        'coordenadas': coordenadas
    }
    print("Área adicionada com sucesso!")

# Função para listar áreas
def listar_areas():
    if not areas_monitoradas:
        print("Nenhuma área encontrada.")
    for id_area, area in areas_monitoradas.items():
        print(f"ID Área: {id_area}, Nome: {area['nome']}, Descrição: {area['descricao']}, Coordenadas: {area['coordenadas']}, ID ONG: {area['id_ong']}")

# Função para adicionar ONG
def adicionar_ong():
    id_ong = validar_entrada("Digite o ID da ONG: ", int)
    nome = validar_entrada("Digite o nome da ONG: ", str)
    endereco = validar_entrada("Digite o endereço da ONG: ", str)
    email = validar_entrada("Digite o email da ONG: ", str)
    telefone = validar_entrada("Digite o telefone da ONG: ", str)
    responsavel = validar_entrada("Digite o responsável pela ONG: ", str)
    ongs[id_ong] = {
        'nome': nome,
        'endereco': endereco,
        'email': email,
        'telefone': telefone,
        'responsavel': responsavel
    }
    print("ONG adicionada com sucesso!")

# Função para listar ONGs
def listar_ongs():
    if not ongs:
        print("Nenhuma ONG encontrada.")
    for id_ong, ong in ongs.items():
        print(f"ID ONG: {id_ong}, Nome: {ong['nome']}, Endereço: {ong['endereco']}, Email: {ong['email']}, Telefone: {ong['telefone']}, Responsável: {ong['responsavel']}")

# Função para adicionar sensor
def adicionar_sensor():
    id_sensor = validar_entrada("Digite o ID do sensor: ", int)
    id_area = validar_entrada("Digite o ID da área: ", int)
    if id_area not in areas_monitoradas:
        print("Área não encontrada.")
        return
    localizacao = validar_entrada("Digite a localização do sensor: ", str)
    tipo = validar_entrada("Digite o tipo do sensor: ", str)
    status = validar_entrada("Digite o status do sensor: ", str)
    dt_instalacao = validar_entrada("Digite a data de instalação do sensor: ", str)
    sensores[id_sensor] = {
        'id_area': id_area,
        'localizacao': localizacao,
        'tipo': tipo,
        'status': status,
        'dt_instalacao': dt_instalacao
    }
    print("Sensor adicionado com sucesso!")

# Função para listar sensores
def listar_sensores():
    if not sensores:
        print("Nenhum sensor encontrado.")
    for id_sensor, sensor in sensores.items():
        print(f"ID Sensor: {id_sensor}, Localização: {sensor['localizacao']}, Tipo: {sensor['tipo']}, Status: {sensor['status']}, Data de Instalação: {sensor['dt_instalacao']}, ID Área: {sensor['id_area']}")

# Função para adicionar medição
def adicionar_medicao():
    id_medicao = validar_entrada("Digite o ID da medição: ", int)
    id_sensor = validar_entrada("Digite o ID do sensor: ", int)
    if id_sensor not in sensores:
        print("Sensor não encontrado.")
        return
    temperatura = validar_entrada("Digite a temperatura: ", float)
    ph = validar_entrada("Digite o valor do pH: ", float)
    oxigenio_dissolvido = validar_entrada("Digite o oxigênio dissolvido: ", float)
    plastico = validar_entrada("Digite a quantidade de plástico: ", float)
    outras_substancias = validar_entrada("Digite outras substâncias: ", str)
    medicoes[id_medicao] = {
        'id_sensor': id_sensor,
        'temperatura': temperatura,
        'ph': ph,
        'oxigenio_dissolvido': oxigenio_dissolvido,
        'plastico': plastico,
        'outras_substancias': outras_substancias
    }
    print("Medição adicionada com sucesso!")

# Função para listar medições
def listar_medicoes():
    if not medicoes:
        print("Nenhuma medição encontrada.")
    for id_medicao, medicao in medicoes.items():
        print(f"ID Medição: {id_medicao}, Temperatura: {medicao['temperatura']}, pH: {medicao['ph']}, Oxigênio Dissolvido: {medicao['oxigenio_dissolvido']}, Plástico: {medicao['plastico']}, Outras Substâncias: {medicao['outras_substancias']}, ID Sensor: {medicao['id_sensor']}")

# Função para adicionar alerta
def adicionar_alerta():
    id_alerta = validar_entrada("Digite o ID do alerta: ", int)
    id_medicao = validar_entrada("Digite o ID da medição: ", int)
    if id_medicao not in medicoes:
        print("Medição não encontrada.")
        return
    tipo_alerta = validar_entrada("Digite o tipo do alerta: ", str)
    status = validar_entrada("Digite o status do alerta: ", str)
    data_hora = validar_entrada("Digite a data e hora do alerta: ", str)
    alertas[id_alerta] = {
        'id_medicao': id_medicao,
        'tipo_alerta': tipo_alerta,
        'status': status,
        'data_hora': data_hora
    }
    print("Alerta adicionado com sucesso!")

# Função para listar alertas
def listar_alertas():
    if not alertas:
        print("Nenhum alerta encontrado.")
    for id_alerta, alerta in alertas.items():
        print(f"ID Alerta: {id_alerta}, Tipo de Alerta: {alerta['tipo_alerta']}, Status: {alerta['status']}, Data e Hora: {alerta['data_hora']}, ID Medição: {alerta['id_medicao']}")

# Função para adicionar ação
def adicionar_acao():
    id_acao = validar_entrada("Digite o ID da ação: ", int)
    id_alerta = validar_entrada("Digite o ID do alerta: ", int)
    if id_alerta not in alertas:
        print("Alerta não encontrado.")
        return
    nome = validar_entrada("Digite o nome da ação: ", str)
    descricao = validar_entrada("Digite a descrição da ação: ", str)
    status = validar_entrada("Digite o status da ação: ", str)
    dt_inicio = validar_entrada("Digite a data de início da ação: ", str)
    dt_fim = validar_entrada("Digite a data de término da ação: ", str)
    acoes[id_acao] = {
        'id_alerta': id_alerta,
        'nome': nome,
        'descricao': descricao,
        'status': status,
        'dt_inicio': dt_inicio,
        'dt_fim': dt_fim
    }
    print("Ação adicionada com sucesso!")

# Função para listar ações
def listar_acoes():
    if not acoes:
        print("Nenhuma ação encontrada.")
    for id_acao, acao in acoes.items():
        print(f"ID Ação: {id_acao}, Nome: {acao['nome']}, Descrição: {acao['descricao']}, Status: {acao['status']}, Data de Início: {acao['dt_inicio']}, Data de Término: {acao['dt_fim']}, ID Alerta: {acao['id_alerta']}")

# Função principal
def main():
    while True:
        print("\nMenu Principal")
        print("1. Adicionar área")
        print("2. Listar áreas")
        print("3. Adicionar ONG")
        print("4. Listar ONGs")
        print("5. Adicionar sensor")
        print("6. Listar sensores")
        print("7. Adicionar medição")
        print("8. Listar medições")
        print("9. Adicionar alerta")
        print("10. Listar alertas")
        print("11. Adicionar ação")
        print("12. Listar ações")
        print("13. Sair")
        opcao = validar_entrada("Escolha uma opção: ", int)
        if opcao == 1:
            adicionar_area()
        elif opcao == 2:
            listar_areas()
        elif opcao == 3:
            adicionar_ong()
        elif opcao == 4:
            listar_ongs()
        elif opcao == 5:
            adicionar_sensor()
        elif opcao == 6:
            listar_sensores()
        elif opcao == 7:
            adicionar_medicao()
        elif opcao == 8:
            listar_medicoes()
        elif opcao == 9:
            adicionar_alerta()
        elif opcao == 10:
            listar_alertas()
        elif opcao == 11:
            adicionar_acao()
        elif opcao == 12:
            listar_acoes()
        elif opcao == 13:
            break
        else:
            print("Opção inválida. Por favor, escolha uma opção válida.")

# Chamar a função principal
if __name__ == "__main__":
    main()
