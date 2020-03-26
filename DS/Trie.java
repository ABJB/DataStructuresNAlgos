import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Trie_Node<ValueType>{
	HashMap<ValueType, Trie_Node<ValueType>> children;
	boolean endWord;
	public Trie_Node(){
		this.children = new HashMap<ValueType, Trie_Node<ValueType>>();
		endWord = false;
	}
	public void setChildren(ValueType value){
		this.children.put(value,new Trie_Node<ValueType>());
	}
	public boolean containsChildren(ValueType value){
		return this.children.containsKey(value);
	}
	public void removeChildren(ValueType value){
		this.children.remove(value);
	}
	public boolean containsAnyChildren(){
		return !this.children.isEmpty();
	}
	public Trie_Node<ValueType> getChildren(ValueType value){
		return this.children.get(value);
	}
	public boolean isEndWord(){
		return this.endWord;
	}
	public void setEndWord(){
		this.endWord=true;
	}
	public void unSetEndWord(){
		this.endWord=false;
	}
}

class Trie{
	private Trie_Node<Character> root;
	public Trie(){
		this.root = new Trie_Node<Character>();
	}

	// Inserting new value in TRIE
	public void insertWord(String s){
		Trie_Node <Character>parser=root;
		for(Character c : s.toCharArray()){
			if(!parser.containsChildren(c)){
				parser.setChildren(c);
			}
			parser = parser.getChildren(c);
		}
		parser.setEndWord();
	}

	// Inserting new prefix
	public void insertPrefix(String s){
		Trie_Node<Character>parser = root;
		for(Character c:s.toCharArray()){
			if(!parser.containsChildren(c)){
				parser.setChildren(c);
			}
			parser = parser.getChildren(c);
		}
	}
	// Check for existing word present
	public boolean wordPresent(String s){
		Trie_Node<Character> parser = root;
		for(Character c : s.toCharArray()){
			if(parser.containsChildren(c)){
				parser=parser.getChildren(c);
			}else{
				return false;
			}
		}
		return parser.isEndWord();
	}

	// Deleting a prefix 
	public boolean deletePrefix(String s){
		Trie_Node<Character> parser = root;
		Stack<Trie_Node<Character>> parse_history = new Stack<Trie_Node<Character>>();
		//Gettting to end of prefix in Trie
		for(Character c:s.toCharArray()){
			if(parser.containsChildren(c) ){
				parse_history.push(parser);
				parser = parser.getChildren(c);
			}else{
				return false;
			}
		}
		//Removing Values
		int index = s.length()-1;
		
		while(parse_history.isEmpty()){
			parser = parse_history.pop();
			char childKey = s.charAt(index--);
			parser.removeChildren(childKey);
			if(parser.containsAnyChildren() || parser.isEndWord()){
			   break; 
			}
		}
		return true;
	}
	// Deleting a word
	public boolean deleteWord(String s){
		Trie_Node<Character> parser = root;
		Stack<Trie_Node<Character>> parse_history = new Stack<Trie_Node<Character>>();
		for(Character c : s.toCharArray()){
			if(parser.containsChildren(c)){
				parse_history.push(parser);
				parser = parser.getChildren(c);
			}else{
				return false;
			}
		}
		if(!parser.isEndWord()){
			return false;
		}
		parser.unSetEndWord();
		if(parser.containsAnyChildren()){
			return true;
		}
		int index = s.length()-1;
		while(parse_history.isEmpty()){
			parser = parse_history.pop();
			char charKey = s.charAt(index--);
			parser.removeChildren(charKey);
			if(parser.containsAnyChildren() || parser.isEndWord()){
				break;
			}
		}
		return true;
	}
	public ArrayList<String> getAllWords(){
		ArrayList <String> allwords = new ArrayList<String>();
		Trie_Node<Character> parser =root;
		Stack<Trie_Node<Character>> parse_history = new Stack<Trie_Node<Character>>();
		Stack<String> parser_string = new Stack <String>();
		parse_history.push(root);
		parser_string.push("");
		String ansistor = "";
		while(parse_history.isEmpty() == false){
			parser = parse_history.pop();
			ansistor=parser_string.pop();
			if(parser.isEndWord()){
				//Save the string ansistor String
				allwords.add(ansistor);
				// parse_history.pop();
			}
			//Reversing keyset will give output in ascending/lexographically increasing order
			for(Character c: parser.children.keySet()){
				parse_history.push(parser.getChildren(c));
				parser_string.push(ansistor+c);
			}                        
		}
		return allwords;
	}
}
