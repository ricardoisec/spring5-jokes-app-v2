package guru.springframework.spring5jokesappv2.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    // Não é possível usar injecção de dependências porque para isso seria necessário registar manualmente a classe
    // guru.springframework.norris.chuck.ChuckNorrisQuotes no injector de dependências, por ser uma classe proveniente
    // de uma library externa, fornecida por terceiros
    public JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {

        return chuckNorrisQuotes.getRandomQuote();
    }
}
