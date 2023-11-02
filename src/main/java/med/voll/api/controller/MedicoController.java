package med.voll.api.controller;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "medicos")
public class MedicoController {
    //injeção de dependencias
    @Autowired
    private MedicoRepository medicoRepository;
    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        //atraves do requestbody consigo pegar o jason q passei no postman colocar na variavel
        // jason e mostrar no console do spring
        medicoRepository.save(new Medico(dados));

    }
}
