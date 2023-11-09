package med.voll.api.controller;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medicos")
public class MedicoController {
    //injeção de dependencias
    @Autowired
    private MedicoRepository medicoRepository;
    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        //atraves do requestbody consigo pegar o jason q passei no postman colocar na variavel
        // jason e mostrar no console do spring
        medicoRepository.save(new Medico(dados));

    }
@GetMapping
//   @Transactional nao irá precisar dessa anotation pois nao estou salvando,
//   atualizando ou exluindo informaçoes, só estou puxando as informaçoes ja existentes
    public Page<DadosListagemMedico> listar(@PageableDefault(size=2, sort={"nome"}) Pageable pageable){
        //no metodo acima eu retorno uma lista dos dados dos medicos pelo record
        //mas o retorno devolve uma list de medico e nao de DadosListagemMedico
    //logo vou converter de medico para DadosListagemMedico com o MAP, atraves do stream.map().tolist()
        return medicoRepository.findAll(pageable).map(DadosListagemMedico::new);
        //DadosListagemMedico precisa ter dentro dele um construtor que receba o objeto do
    // tipo medico, logo precisa criar esse construtor dentro do record DadosListagemMedico,
    // que recebe como parametro um objeto do tipo medico
    }
}
 