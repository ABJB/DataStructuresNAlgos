class ImplementPowerFunction{
    /*
        Problem : Implement pow(x, n) % d.
        In other words, given x, n and d,
        Example : 
            Input : x = 2, n = 3, d = 3
            Output : 2
    */
    public int solve(int  x, int n , int d){
        if( n == 1 ){
            return x%d;
        }else if(n==0){
            return x%d;
        }
        int base = x%d;
        int powr = 1;
        while(powr*2<=n){
            powr*=2;
            base=(base%d*base%d) % d;
        }

        int call = solve(x, n-powr, d);
        return (base*call)%d;

    }
}