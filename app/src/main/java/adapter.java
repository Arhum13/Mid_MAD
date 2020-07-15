public class adapter extends RecyclerView.Adapter<adapter.Myclass> {
        Context c;
        ArrayList<working>a1;

        public adapter(Context c, ArrayList<working> a1) {
            this.c = c;
            this.a1 = a1;
        }

        public class Myclass extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView t1,t2,t3,t4;
            ImageView i1;
            LinearLayout l1;
            public Myclass(@NonNull View itemView) {

                super(itemView);

                t1=(TextView) itemView.findViewById(R.id.text1);
                t2=(TextView) itemView.findViewById(R.id.text2);
                t3=(TextView)itemView.findViewById(R.id.text3);
                t4=(TextView)itemView.findViewById(R.id.text4);
                i1=(ImageView)itemView.findViewById(R.id.ii);
                l1=(LinearLayout)itemView.findViewById(R.id.LL1);
                itemView.setOnClickListener(this);

            }


            @Override
            public void onClick(View view) {
                working g1=a1.get(getAdapterPosition());
                AlertDialog.Builder alert=new AlertDialog.Builder(view.getRootView().getContext());
                alert.setTitle("Details");
                alert.setMessage("Name :"+g1.getName()+"\n"+" Age :"+g1.getAge()+"\n"+" Gender :"+g1.getGender()+"\n"+" Hobbies :"+g1.getHobbies());

                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog a1=alert.create();
                alert.show();

            }
        }
        public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflate=LayoutInflater.from(parent.getContext());
            View view=inflate.inflate(R.layout.row_file,parent,false);
            return new Myclass(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Myclass holder, int position) {

            working g1=a1.get(position);
            byte[] bb=g1.getNewImg();
            Bitmap bitmap= BitmapFactory.decodeByteArray(bb,0,bb.length);
            holder.i1.setImageBitmap(bitmap);
        }
        @Override
        public int getItemCount() {
            return a1.size();
        }
    }
}
