<template>
  <div>
    <h2>Espaços Físicos Cadastrados</h2>
    <b-table striped hover :items="espacos" :fields="fields">
      <!-- Coluna personalizada para recursos -->
      <template v-slot:cell(recursos)="data">
        <ul>
          <li v-for="(recurso, index) in JSON.parse(data.value)" :key="index">{{ recurso }}</li>
        </ul>
      </template>

      <!-- Coluna personalizada para ações (editar e deletar) -->
      <template v-slot:cell(acoes)="data">
        <b-button variant="warning" @click="editarEspaco(data.item.id)" class="mr-2">
          <b-icon icon="pencil"></b-icon> Editar
        </b-button>
        <b-button variant="danger" @click="confirmarDelecao(data.item.id)">
          <b-icon icon="trash"></b-icon> Deletar
        </b-button>
      </template>
    </b-table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      espacos: [],
      fields: [
        { key: 'id', label: 'ID' },
        { key: 'nome', label: 'Nome' },
        { key: 'descricao', label: 'Descrição' },
        { key: 'tipo', label: 'Tipo' },
        { key: 'capacidade', label: 'Capacidade' },
        { key: 'recursos', label: 'Recursos' },
        { key: 'localizacao', label: 'Localização' },
        { key: 'situacao', label: 'Situação' },
        { key: 'dataCadastro', label: 'Data de Cadastro' },
        { key: 'notasAdicionais', label: 'Notas Adicionais' },
        { key: 'acoes', label: 'Ações' } // Nova coluna para ações
      ]
    };
  },
  created() {
    this.fetchEspacos();
  },
  methods: {
    async fetchEspacos() {
      try {
        const response = await axios.get('http://localhost:8080/api/espaco/all');
        this.espacos = response.data._embedded.espacoFisicoList;
      } catch (error) {
        console.error('Erro ao buscar espaços físicos:', error);
      }
    },
    editarEspaco(id) {
      // Redireciona para a página de edição (substitua pela sua lógica de edição)
      alert(`Editar espaço físico com ID: ${id}`);
      // Exemplo: this.$router.push(`/editar-espaco/${id}`);
    },
    async confirmarDelecao(id) {
      // Confirmação antes de deletar
      if (confirm('Tem certeza que deseja deletar este espaço físico?')) {
        try {
          await axios.delete(`http://localhost:8080/api/espaco/deletar/${id}`);
          alert('Espaço físico deletado com sucesso!');
          this.fetchEspacos(); // Recarrega a lista após deletar
        } catch (error) {
          console.error('Erro ao deletar espaço físico:', error);
          alert('Erro ao deletar espaço físico.');
        }
      }
    }
  }
};
</script>

<style scoped>
h2 {
  margin-bottom: 20px;
}

/* Estilo para os botões */
.mr-2 {
  margin-right: 8px;
}
</style>