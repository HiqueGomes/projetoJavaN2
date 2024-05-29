package br.mackenzie.webapp.professor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class DonoController {

  @Autowired
  private DonoRepo donoRepo;

  public DonoController() {

  }

  @GetMapping("/api/donos")
  Iterable<Dono> getDonos(@RequestParam Optional<Long> donoId) {

    return donoRepo.findAll();

  }

  @GetMapping("/api/donos/{id}")
  Optional<Dono> getDono(@PathVariable long id) {
    return donoRepo.findById(id);
  }

  @PostMapping("/api/donos")
  Dono createDono(@RequestBody Dono t) {
    Dono createdDono = donoRepo.save(t);
    return createdDono;
  }

  @PutMapping("/api/donos/{donoId}")
  Optional<Dono> updateDono(@RequestBody Dono donoRequest, @PathVariable long donoId) {
    Optional<Dono> opt = donoRepo.findById(donoId);
    if (opt.isPresent()) {
      if (donoRequest.getId() == donoId) {
        donoRepo.save(donoRequest);
        return opt;
      }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Erro ao alterar dados do dono com id " + donoId);
  }

  @DeleteMapping(value = "/api/donos/{id}")
  void deleteDono(@PathVariable long id) {
    donoRepo.deleteById(id);
  }
}