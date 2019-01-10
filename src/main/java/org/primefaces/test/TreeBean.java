package org.primefaces.test;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class TreeBean implements Serializable {

    private TreeNode root = new DefaultTreeNode("Root Node", null);

    public TreeBean() {
        // Populate Document Instances
        Document doc01 = new Document("Primefaces Tutorial", "1", "Primefaces Company");
        Document doc02 = new Document("Hibernate Tutorial", "2", "JournalDev");

        // Create Documents TreeNode
        TreeNode documents = new DefaultTreeNode(new Document("Documents", "0", "Documents"), this.root);
        // Create Document TreeNode
        TreeNode document01 = new DefaultTreeNode(doc01, documents);
        TreeNode document02 = new DefaultTreeNode(doc02, documents);

        for (int i = 3; i < 100; i++) {
            new DefaultTreeNode(new Document("bla" + i, "" + i, "bla" + i), documents);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}