package modelo;

import java.util.ArrayList;
import java.util.List;

public class AlbumDAOClasse implements AlbumDAO {

    private static AlbumDAOClasse instance;

    private List<Album> albuns;

    private AlbumDAOClasse() {
        albuns = new ArrayList();
    }



    public synchronized static AlbumDAO getInstance() {
        if (instance == null) {
            instance = new AlbumDAOClasse();
        }

        return instance;
    }

    @Override
    public Album criarAlbum(Album album) {
        albuns.add(album);
        return album;
    }

    @Override
    public List<Album> listarAlbuns() {
        return albuns;
    }
}
