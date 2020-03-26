import java.util.ArrayList;
class Fast_Trie_Node{
	Fast_Trie_Node []children;
	boolean isWord;
}

class Fast_Trie{
	Fast_Trie_Node root;

	public Fast_Trie(){
		root = new Fast_Trie_Node();
		root.children=new Fast_Trie_Node[26];
	}
	// Insert word 
	public void insertWord(String s){
		Fast_Trie_Node parser = root;
		for(Character c:s.toCharArray()){
            // System.out.println(c);
			if(parser.children[c-'a']==null){
                parser.children[c-'a'] = new Fast_Trie_Node();
                parser.children[c-'a'].children = new Fast_Trie_Node[26];
			}
            parser = parser.children[c-'a'];
		}
		parser.isWord=true;
	}
	// Check a word
	public boolean checkWord(String s){

		Fast_Trie_Node parser = root;
		for(Character c : s.toCharArray()){
			if(parser.children[c-'a'] == null){
				return false;
			}
			parser = parser.children[c-'a'];
		}
		return (parser.isWord)?true:false;
	}
	// Check a prefix
	public boolean checkPrefix(String s){
		Fast_Trie_Node parser = root;
		for(Character c:s.toCharArray()){
			if(parser.children[c-'a']==null){
				return false;
			}
		}
		return true;
	}
	// Delete a word
	public boolean deleteWord(String s){
		Fast_Trie_Node parser = root;
		//Assuming 100 is maximum lenghth of biggest word in trie
		Fast_Trie_Node []parse_history = new Fast_Trie_Node[100];
		int parse_history_index = -1;

		for(Character c: s.toCharArray()){
			if(parser.children[c-'a'] == null){
				return false;
			}
			parse_history[++parse_history_index]=parser;
			parser = parser.children[c-'a'];
		}
		if(!parser.isWord){
			return false;
		}
		parser.isWord=false;

		// Removing Nodes if they don't have any childrens
		while(parse_history_index>-1){
			parser = parse_history[parse_history_index];
			parser.children[s.charAt(parse_history_index--) - 'a'] = null;
			for(Fast_Trie_Node temp:parser.children){
				if(temp != null || parser.isWord){
					return true;
				}
			}
		}
		return true;
	}

	public boolean deletePrefix(String s){
		Fast_Trie_Node parser = root;
		//Assumption 100 is max word lenght
		Fast_Trie_Node []parse_history = new Fast_Trie_Node[100];
		int parse_history_index = -1;
		for(Character c:s.toCharArray()){
			if(parser.children[c-'a']==null){
				return false;
			}
			parse_history[++parse_history_index] = parser;
			parser = parser.children[c-'a'];
		}

		while(parse_history_index>-1){
			parser = parse_history[parse_history_index];
			parser.children[s.charAt(parse_history_index--)-'a']=null;
			for(Fast_Trie_Node temp : parser.children){
				if(temp!=null || parser.isWord){
					return true;
				}
			}
		}
		return true;
    }
    
    public ArrayList<String> getAllWord(){
        ArrayList <String> allwords = new ArrayList<String>();

        Fast_Trie_Node parser , parse_history[]=new Fast_Trie_Node[10000];
        int parse_history_index = 0;
        parse_history[0]=root;
        String stringStack[] = new String[10000];
        stringStack[0] = "";
        while(parse_history_index>=0){
            parser = parse_history[parse_history_index];
            String ansistor = stringStack[parse_history_index--];
            if(parser.isWord){
                allwords.add(ansistor);
            }
            for(int i=parser.children.length-1;i>-1;i--){
                if(parser.children[i] != null){
                    parse_history[++parse_history_index]=parser.children[i];
                    stringStack[parse_history_index]=ansistor+(char)('a'+i);
                }
            }
        }
        return allwords;
    }

}