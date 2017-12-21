public class BinarySearchTree
{
	//structure node
	class TREE
		{
       int data;
       public TREE(int data)
       {
       	this.data=data;
       }
       TREE left;
       TREE right;
      	 };
//insert
TREE insert(TREE tree,int number)
{
     TREE store=tree;
     TREE node=new TREE(number);
     node.left=null;
     node.right=null;
     
     if(tree==null) {
                         tree=node;
                         return tree;
                    }
                    
     else           {
                             while(true)
                                  {
                                       				if(number<=tree.data) {
                                                             if(tree.left==null) {tree.left=node;break;}
                                                             else {tree=tree.left;continue;}
                                                             }
                                         			else                {
                                                             if(tree.right==null) {tree.right=node;break;}
                                                             else {tree=tree.right;continue;}
                                                             }
                                                             
                                  }
                                  tree=store;
                                  return tree;
                                  
                    }
}
//inorder
void inorder(TREE tree)
{
	
	 if(tree!=null){
     if(tree.left!=null) inorder(tree.left);
     System.out.print(" "+tree.data);
     if(tree.right!=null) inorder(tree.right);
	 }
     }
//preorder
void preorder(TREE tree)
{
	if(tree!=null){
     System.out.print(" "+tree.data);
     if(tree.left!=null) preorder(tree.left);
     if(tree.right!=null) preorder(tree.right);
	}
     }
//postorder
void postorder(TREE tree)
{
	if(tree!=null){
     if(tree.left!=null) postorder(tree.left);
     if(tree.right!=null) postorder(tree.right);
     System.out.print(" "+tree.data);
	}
     }
//search
int search(TREE tree,int number)
{
    int i=0;
         while(tree!=null)
             {
                        if(tree.data==number) {System.out.println("value found");break;}
                        else if(number<tree.data) {tree=tree.left;i++;}
                        else if(number>tree.data) {tree=tree.right;i++;}
                        }
                        return i;
}
//delete
TREE deletE(TREE tree,int number)
{
			TREE x=tree,y=tree;
			if(tree==null) return tree;
			else
			{
				while(x.data!=number)
				{
					if(number<x.data) {y=x;x=x.left;}
					else if(number>x.data) {y=x;x=x.right;}
					if(x==null) break;
				}
				if(x!=null)
				{
					if(x.left==null&&x.right==null)
					{
						if(x==y.left) y.left=null;
						else if(x==y.right) y.right=null;
						else if(x==y) tree=null;
					}
					else if(x.left!=null||x.right!=null)
					{
						if(x.left==null)
						{
							if(x==y.left) y.left=x.right;
							else if(x==y.right) y.right=x.right;
							else if(x==y) tree=x.right;
						}
						else if(x.right==null)
						{
							if(x==y.left) y.left=x.left;
							else if(x==y.right) y.right=x.left;
							else if(x==y) tree=x.left;
						}
						else
						{
								TREE prep=x,pre=x;
								prep=prep.left;
								while(prep.right!=null) {pre=prep;prep=prep.right;}
							if(x==y)
							{
								x.data=prep.data;
								if(prep==pre.left) pre.left=prep.left;
								else if(prep==pre.right) pre.right=prep.left; 
							}
							else
							{
								x.data=prep.data;
								if(prep==pre.left) pre.left=prep.left;
								else if(prep==pre.right) pre.right=prep.left; 
							}
						}
					}
				}
			}
			return tree;
     }
//main
int number;
TREE sid=null;
int num,range;

public BinarySearchTree()
{
	sid=insert(sid,3);
	sid=insert(sid,1);
	sid=insert(sid,5);
	sid=insert(sid,2);
	sid=insert(sid,4);
	sid=insert(sid,6);
}
public static void main(String args[])
{
    new BinarySearchTree();
}
}