package task.valdemarc.ibanvalitator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.valdemarc.ibanvalitator.model.Iban;
import task.valdemarc.ibanvalitator.service.IbanValidationServices;

@RestController
@RequestMapping("iban")
public class IbanController {

    @GetMapping(path="/v1/{iban}")
    public String validateIban(@PathVariable String iban){


        IbanValidationServices ibanValidationServices = new IbanValidationServices();
        Iban ibanObj = ibanValidationServices.separateIban(iban);
        ibanValidationServices.validateIban(ibanObj);

        if(ibanValidationServices.validateIban(ibanObj)){
            return iban + " is Valid!!!";
        }
        return iban + " is not Valid!!!";
    }

    @GetMapping(path="/v2/{iban}")
    public String validateIbanIsSeb(@PathVariable String iban){


        IbanValidationServices ibanValidationServices = new IbanValidationServices();
        Iban ibanObj = ibanValidationServices.separateIban(iban);
        ibanValidationServices.validateIban(ibanObj);

        if(ibanValidationServices.validateIban(ibanObj) && ibanValidationServices.isIbanFromSeb(ibanObj)){
            return iban + " is Valid and belongs for SEB";
        }
        return iban + " is not Valid or not SEB IBAN";
    }

}
