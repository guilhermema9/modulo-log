<template>
  <div id="app">
    <b-container>
      <b-row>
        <b-col>
          <h1>Response JSON</h1>
          <pre>{{ jsonResponse }}</pre>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      jsonResponse: ''
    };
  },
  mounted() {
    axios.get('http://localhost:8080/api/espaco/all')
        .then(response => {
          this.jsonResponse = JSON.stringify(response.data, null, 2);
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
pre {
  text-align: left;
  background-color: #f8f9fa;
  padding: 10px;
  border-radius: 5px;
}
</style>
