package br.com.fiap.oceamwave;

import java.util.Scanner;

import br.com.fiap.oceamwave.manager.ColaboradorManager;
import br.com.fiap.oceamwave.manager.OngManager;

public class App {
    private OngManager ongManager;
    private ColaboradorManager colaboradorManager;

    public App() {
        this.ongManager = new OngManager(); // Inicializa o gerenciador de ONGs
        this.colaboradorManager = new ColaboradorManager(); // Inicializa o gerenciador de Colaboradores
        inicializarDadosDeTeste(); // Inicializa objetos de teste
    }

    public static void main(String[] args) {
        App app = new App(); // Inicializa a aplicação
        if (app.login()) {
            app.menuPrincipal(); // Exibe o menu principal
        } else {
            System.out.println("Login falhou. Encerrando aplicação.");
        }
    }

    // Método de login
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        int senha = scanner.nextInt();

        Colaborador colaborador = colaboradorManager.buscarPorEmailESenha(email, senha);
        if (colaborador != null) {
            System.out.println("Login bem-sucedido. Bem-vindo, " + colaborador.getNome() + "!");
            return true;
        } else {
            System.out.println("Email ou senha incorretos.");
            return false;
        }
    }

    // Menu principal
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Menu Principal:");
            System.out.println("1. Adicionar ONG");
            System.out.println("2. Adicionar Sensor a uma ONG");
            System.out.println("3. Mostrar Sensores de uma ONG");
            System.out.println("4. Adicionar Medição a um Sensor");
            System.out.println("5. Verificar Alertas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarOng(scanner); // Chama o método para adicionar ONG
                    break;
                case 2:
                    adicionarSensor(scanner); // Chama o método para adicionar Sensor
                    break;
                case 3:
                    mostrarSensores(scanner); // Chama o método para mostrar Sensores
                    break;
                case 4:
                    adicionarMedicaoASensor(scanner); // Chama o método para adicionar Medição
                    break;
                case 5:
                    verificarAlertas(scanner); // Chama o método para verificar Alertas
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Criar ONG e Sensores para testes
    private void inicializarDadosDeTeste() {
        // Criar uma ONG
        Ong ong1 = new Ong("ONG Teste", "Rua Teste, 123", "1234-5678", "teste@ong.com");
        ongManager.adicionarOng(ong1);

        // Criar Sensores
        Sensor sensor1 = new Sensor("Localização A", "Tipo A", "Ativo", "2023-01-01", ong1);
        Sensor sensor2 = new Sensor("Localização B", "Tipo B", "Ativo", "2023-02-01", ong1);
        ong1.adicionarSensor(sensor1);
        ong1.adicionarSensor(sensor2);

        // Adicionar Medições
        sensor1.adicionarMedicao("2024-05-01 10:00", "Tipo1", 35, "Detalhes");
        sensor1.adicionarMedicao("2024-05-01 11:00", "Tipo2", 5, "Detalhes");
        sensor1.adicionarMedicao("2024-05-01 12:00", "Tipo3", 25, "Detalhes");

        sensor2.adicionarMedicao("2024-05-01 13:00", "Tipo4", 32, "Detalhes");
        sensor2.adicionarMedicao("2024-05-01 14:00", "Tipo5", 9, "Detalhes");

        Colaborador colaborador = new Colaborador("Colaborador Teste", "Rua Teste, 123", "1234-5678", "teste@", 1234); // Usar teste@ para login teste
        colaboradorManager.adicionarColaborador(colaborador);
    }

    // Adicionar ONG
    public void adicionarOng(Scanner scanner) {
        System.out.print("Nome da ONG: ");
        String nomeOng = scanner.nextLine();
        System.out.print("Endereço da ONG: ");
        String enderecoOng = scanner.nextLine();
        System.out.print("Telefone da ONG: ");
        String telefoneOng = scanner.nextLine();
        System.out.print("Email da ONG: ");
        String emailOng = scanner.nextLine();

        Ong ong = new Ong(nomeOng, enderecoOng, telefoneOng, emailOng);
        ongManager.adicionarOng(ong);

        System.out.println("ONG adicionada com sucesso!");
    }

    // Adicionar Sensor a uma ONG
    public void adicionarSensor(Scanner scanner) {
        System.out.print("Nome da ONG: ");
        String nomeOng = scanner.nextLine();

        Ong ong = ongManager.buscarOngPorNome(nomeOng);
        if (ong == null) {
            System.out.println("ONG não encontrada.");
            return;
        }

        System.out.print("Localização do Sensor: ");
        String localizacao = scanner.nextLine();
        System.out.print("Tipo do Sensor: ");
        String tipo = scanner.nextLine();
        System.out.print("Status do Sensor: ");
        String status = scanner.nextLine();
        System.out.print("Data de Instalação do Sensor: ");
        String dt_instalacao = scanner.nextLine();

        Sensor sensor = new Sensor(localizacao, tipo, status, dt_instalacao, ong);
        ong.adicionarSensor(sensor);

        System.out.println("Sensor adicionado com sucesso!");
    }

    // Pesquisar sensores pelo nome da ONG e exibir.
    public void mostrarSensores(Scanner scanner) {
        System.out.print("Nome da ONG: ");
        String nomeOng = scanner.nextLine();

        Ong ong = ongManager.buscarOngPorNome(nomeOng);
        if (ong == null) {
            System.out.println("ONG não encontrada.");
            return;
        }

        for (Sensor sensor : ong.getSensores()) {
            System.out.println("Sensor:");
            System.out.println("Localização: " + sensor.getLocalizacao());
            System.out.println("Tipo: " + sensor.getTipo());
            System.out.println("Status: " + sensor.getStatus());
            System.out.println("Data de Instalação: " + sensor.getDt_instalacao());
            System.out.println("ONG: " + sensor.getFonteOng().getNome());
            System.out.println("------------");
        }
    }

    // Adicionar Medição a sensores já criados.
    public void adicionarMedicaoASensor(Scanner scanner) {
        System.out.print("Nome da ONG: ");
        String nomeOng = scanner.nextLine();

        Ong ong = ongManager.buscarOngPorNome(nomeOng);
        if (ong == null) {
            System.out.println("ONG não encontrada.");
            return;
        }

        System.out.print("Localização do Sensor: ");
        String localizacaoSensor = scanner.nextLine();

        Sensor sensor = buscarSensorPorLocalizacao(ong, localizacaoSensor);
        if (sensor == null) {
            System.out.println("Sensor não encontrado.");
            return;
        }

        System.out.print("Data e Hora da Medição: ");
        String dt_hora = scanner.nextLine();
        System.out.print("Tipo da Medição: ");
        String tipo = scanner.nextLine();
        System.out.print("Temperatura: ");
        int temp = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Outros Detalhes: ");
        String outrosDetalhes = scanner.nextLine();

        sensor.adicionarMedicao(dt_hora, tipo, temp, outrosDetalhes);

        System.out.println("Medição adicionada com sucesso!");
    }

    private Sensor buscarSensorPorLocalizacao(Ong ong, String localizacao) {
        for (Sensor sensor : ong.getSensores()) {
            if (sensor.getLocalizacao().equals(localizacao)) {
                return sensor;
            }
        }
        return null;
    }

    // Verificar Alertas pelo nome da ONG
    public void verificarAlertas(Scanner scanner) {
        System.out.print("Nome da ONG: ");
        String nomeOng = scanner.nextLine();

        Ong ong = ongManager.buscarOngPorNome(nomeOng);
        if (ong == null) {
            System.out.println("ONG não encontrada.");
            return;
        }

        for (Sensor sensor : ong.getSensores()) {
            System.out.println("Alertas para o sensor na localização: " + sensor.getLocalizacao());
            for (Alerta alerta : sensor.getAlertas()) {
                System.out.println(alerta); // Utiliza o método toString sobrescrito
                System.out.println("-----------");
            }
        }
    }
}
