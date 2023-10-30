package med.voll.api.controller;
import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "medicos")
public class MedicoController {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        //atraves do requestbody consigo pegar o jason q passei no postman colocar na variavel
        // jason e mostrar no console do spring
        System.out.println(dados);
    }
}
