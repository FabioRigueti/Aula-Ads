import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Evento> eventos;

    public EventManager() {
        this.eventos = new ArrayList<>();
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento.getNome() + " - " + evento.getHorario());
        }
    }

    public void salvarEventos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("events.data"))) {
            out.writeObject(eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarEventos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("events.data"))) {
            eventos = (List<Evento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Outros métodos conforme necessário...
}
