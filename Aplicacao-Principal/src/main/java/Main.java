import database.model.*;
import database.service.*;
import database.template.TemplateMySQL;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        TemplateMySQL templateMySQL = new TemplateMySQL();

        int delay = 2000;
        int intervalo = 15000;
        Timer timer = new Timer();

        AtmService atmService = new AtmService();
        ProcessadorService processadorService = new ProcessadorService();
        MemoriaService memoriaService = new MemoriaService();
        DiscoService discoService= new DiscoService();
        DispositivoUsbService dispositivoUsbService = new DispositivoUsbService();
        RegistroService registroService = new RegistroService();
        RegistroDispositivoUsbConectadoService registroDispositivoUsbConectadoService = new RegistroDispositivoUsbConectadoService();
        GerenciadorRecursos gerenciadorRecursos = new GerenciadorRecursos();

        atmService.inserirDadosAtm();
        processadorService.inserirDadosProcessador();
        memoriaService.inserirDadosMemoria();
        discoService.inserirPegarModeloVolumeDiscoLooca();
        dispositivoUsbService.inserirPegarNomeDispositivo();

        List<BancoModel> listaTeste = templateMySQL.getTemplateMySQl().query("""
                select * from banco;
                """, new BeanPropertyRowMapper<>(BancoModel.class)
        );

        System.out.println(listaTeste);


        System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from atm;
                """, new BeanPropertyRowMapper<>(AtmModel.class))
        );

        System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from processador;
                """, new BeanPropertyRowMapper<>(ProcessadorModel.class))
        );

        System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from memoria;
                """, new BeanPropertyRowMapper<>(MemoriaModel.class))
        );

        System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from disco;
                """, new BeanPropertyRowMapper<>(DiscoModel.class))
        );

        System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from dispositivousb;
                """, new BeanPropertyRowMapper<>(DispositivoUsbModel.class))
        );
        gerenciadorRecursos.setVisible(true);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                registroService.inserirDadosRegistro();
                registroDispositivoUsbConectadoService.inserirDadosRegistroUsb();

                System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from registro;
                """, new BeanPropertyRowMapper<>(RegistroModel.class)));

                System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from registrodispositivousbconectado limit 1;
                """, new BeanPropertyRowMapper<>(RegistroDispositivoUsbConectadoModel.class)));
            }
        }, delay, intervalo);
    }
}