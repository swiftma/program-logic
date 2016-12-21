package shuo.laoma.collection.c35;

public class Pair<T> {
	T first;
	T second;

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

}
