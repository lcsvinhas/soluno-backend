package app.netlify.soluno.service;

import app.netlify.soluno.dto.UsuarioRequestDTO;
import app.netlify.soluno.dto.UsuarioResponseDTO;
import app.netlify.soluno.entity.Usuario;
import app.netlify.soluno.exception.UsuarioException;
import app.netlify.soluno.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(u -> new UsuarioResponseDTO(
                u.getId(),
                u.getNome(),
                u.getSobrenome(),
                u.getReceitas(),
                u.getDespesas()
        )).toList();
    }

    public UsuarioResponseDTO buscarPorID(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException("Usuário não cadastrado"));
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getReceitas(),
                usuario.getDespesas()
        );
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new UsuarioException("Usuário já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setTelefone(usuarioRequestDTO.getTelefone());
        usuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getReceitas(),
                usuario.getDespesas()
        );
    }

    public UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO usuarioRequestDTO, Long id) {
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new UsuarioException("Usuário já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setTelefone(usuarioRequestDTO.getTelefone());
        usuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getReceitas(),
                usuario.getDespesas()
        );
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException("Usuário não cadastrado"));
        usuarioRepository.delete(usuario);
    }
}