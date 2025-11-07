package app.netlify.soluno.controller;

import app.netlify.soluno.dto.UsuarioRequestDTO;
import app.netlify.soluno.dto.UsuarioResponseDTO;
import app.netlify.soluno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorID(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorID(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
