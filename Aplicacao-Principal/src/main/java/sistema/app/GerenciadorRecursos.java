package sistema.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

import sistema.database.service.DiscoService;
import sistema.database.service.RegistroService;

import java.awt.*;

public class GerenciadorRecursos extends JFrame {
    Looca looca = new Looca();
    DiscoService discoService = new DiscoService();
    RegistroService registroService = new RegistroService();
    Long qtdDisponivelDiscoBytes;
    JTable table;

    public GerenciadorRecursos() {
        setTitle("Interface do Caixa Eletrônico");
        setSize(600, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        table = new JTable();
        table.setSize(600, 300);
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(450, table.getHeight()));
        panel.add(scrollPane);
        this.add(panel);
        this.setLocationRelativeTo(null);

        Timer timer = new Timer(1000, e -> atualizarTabela());
        timer.start();
    }

    private void atualizarTabela() {
        for (int i = 0; i < discoService.pegarListaDiscoLooca().size(); i++) {
            qtdDisponivelDiscoBytes = discoService.pegarListaVolumeLooca().get(i).getDisponivel();
        }

        String sistOperacional = looca.getSistema().getSistemaOperacional();
        String cpu = looca.getProcessador().getNome();
        String usoCpu = registroService.pegarPorcentagemUsoProcessador();
        String memoriaTot = Conversor.formatarBytes(looca.getMemoria().getTotal());
        String memoriaDisp = Conversor.formatarBytes(looca.getMemoria().getDisponivel());
        String tempoAtivo = Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
        String processos = looca.getGrupoDeProcessos().getTotalProcessos().toString();
        String discoTotal = Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
        String discoDisp = Conversor.formatarBytes(qtdDisponivelDiscoBytes);
        String servicos = looca.getGrupoDeServicos().getTotalDeServicos().toString();
        String usb = looca.getDispositivosUsbGrupo().getTotalDispositvosUsbConectados().toString();


        String[][] data =
                {{"Sistema Operacional: ", sistOperacional},
                {"CPU:", cpu},
                {"Uso CPU: ", usoCpu},
                {"RAM Total:", memoriaTot},
                {"RAM Disponível: ", memoriaDisp},
                {"Tempo Ativo: ", tempoAtivo},
                {"Processos Ativos: ", processos},
                {"Disco Total:", discoTotal},
                {"Disco Disponível: ", discoDisp},
                {"Total de serviços: ", servicos},
                {"USBs Conectados: ", usb}};

        String[] columnNames = {"Componente", "Status"};

        table.setModel(new DefaultTableModel(data, columnNames));
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    public static void main(String[] args) {
        GerenciadorRecursos gerenciadorRecursos = new GerenciadorRecursos();
        gerenciadorRecursos.setVisible(true);
    }
}
