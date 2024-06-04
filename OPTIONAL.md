
Metodi per creare un'istanza Optional in Java:
1. Creare un Optional da un valore non nullo:

Optional.of(T value): Crea un Optional contenente il valore non nullo value. Se value è nullo, viene sollevata un'eccezione NullPointerException.
2. Creare un Optional vuoto:

Optional.empty(): Crea un Optional vuoto, senza alcun valore al suo interno.
3. Creare un Optional da un fornitore:

Optional.fromNullable(Supplier<T> supplier): Crea un Optional dal valore restituito dal fornitore supplier. Se supplier restituisce nullo, viene creato un Optional vuoto.
4. Conversione da altri tipi:

- Optional.ofNullable(Int): Per tipi primitivi wrapper (es. Integer, Double, ecc.).
- Optional.ofNullable(Stream<T>): Da uno stream.
- Optional.ofNullable(CompletableFuture<T>): Da un CompletableFuture.
- Optional.ofNullable(name); in Java crea un oggetto Optional che racchiude il valore della variabile name.
  Se name è nullo, Optional.ofNullable crea un oggetto Optional vuoto.
  Se name non è nullo, Optional.ofNullable crea un oggetto Optional che contiene il valore di name.





a. BiFunction<List<Integer>, Integer, List<Integer>> filterGreaterThan = (list, value) -> list.stream().filter(n -> n > value).collect(Collectors.toList());
b. BiFunction<List<Integer>, Integer, List<Integer>> filterGreaterThan = (list, value) -> list.stream().map(n -> n > value).collect(Collectors.toList());
c. BiFunction<List<Integer>, Integer, List<Integer>> filterGreaterThan = (list, value) -> { List<Integer> result = new ArrayList<>(); for (Integer n : list) if (n > value) result.add(n); return result; };
d. BiFunction<List<Integer>, Integer, List<Integer>> filterGreaterThan = (list, value) -> list.stream().reduce((acc, n) -> { if (n > value) acc.add(n); return acc; }).orElse(new ArrayList<>());