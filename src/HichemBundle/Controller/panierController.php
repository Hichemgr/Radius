<?php

namespace HichemBundle\Controller;

use Doctrine\DBAL\Types\TextType;
use HichemBundle\Entity\Ligneproduit;
use HichemBundle\Entity\Panier;
use HichemBundle\Entity\Produit;
use HichemBundle\Entity\Utilisateur;
use HichemBundle\Form\LigneproduitType;
use HichemBundle\Form\PanierType;
use HichemBundle\Repository\PanierRepository;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Doctrine\DBAL\Types\Type;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\FormTypeInterface;
use Knp\Bundle\SnappyBundle\Snappy\Response\PdfResponse;


class panierController extends Controller
{
   /* public function indexAction()
    {
        return $this->render('@Hichem/Default/index.html.twig');
    }*/



    public function addAction($id,$quantite)
    {
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;


        $iduser=11;
        $repo=$this->getDoctrine()->getRepository(Panier::class);
        $user=$this->getDoctrine()->getRepository(Utilisateur::class);
        $userid=$user->findOneBy(array('idutilisateur' => $idd));
        $prod=$this->getDoctrine()->getRepository(Produit::class);
        $produitid=$prod->findOneBy(array('idproduit' => $id));







        $panier=$repo->findOneBy(array('etat' => 0, 'idutilisateur' => $userid));

        if($panier==NULL)
        {
            $newpanier=new Panier();
            $newpanier->setIdutilisateur($userid);
            $newpanier->setEtat(0);
            $em=$this->getDoctrine()->getManager();
            $em->persist($newpanier);
            $em->flush();

            $newid=$newpanier->getIdpanier();
            $newligneproduit=new Ligneproduit();
            $newligneproduit->setIdpanier($newpanier);

          /*  $e = $request->request->get('value');
            $q = $newligneproduit->getQuantite();
            $newligneproduit->setQuantite($e);*/

            $listpp = $this->getDoctrine()->getRepository(Ligneproduit::class)->findAll();
            $i=0;
            foreach ($listpp as $value )
                if(($value->getIdproduit()==$produitid)&&($value->getIdpanier()==$panier))
                {
                    $i=1;

                }
            if($i==1)
            {
                $this->get('session')->getFlashBag()->add(
                    'notice',
                    'Produit déjà ajouté'
                );
            }
            if($i==0) {


                $newligneproduit->setIdproduit($produitid);
                $newligneproduit->setQuantite($quantite);

                $em->persist($newligneproduit);
                $em->flush();
            }

        }
        else
        {
            $panId=$panier->getIdpanier();
            $newligneproduit=new Ligneproduit();
            $newligneproduit->setIdpanier($panier);


            $listpp = $this->getDoctrine()->getRepository(Ligneproduit::class)->findAll();
            $i=0;
            foreach ($listpp as $value )
            if(($value->getIdproduit()==$produitid)&&($value->getIdpanier()==$panier))
            {
                $i=1;

            }
            if($i==1)
            {
                $this->get('session')->getFlashBag()->add(
                    'notice',
                    'Produit déjà ajouté'
                );
            }
            if($i==0)
            {


                $newligneproduit->setIdproduit($produitid);

                /* $e = $request->request->get('value');
                 $q = $newligneproduit->getQuantite();
                 $newligneproduit->setQuantite($e);*/
                $newligneproduit->setQuantite($quantite);
                $em = $this->getDoctrine()->getManager();
                $em->persist($newligneproduit);
                $em->flush();
            }

        }






        //return $this->render('@Hichem/Front/listproduit.html.twig');
        return $this->redirectToRoute("listproduit");
    }

    public function deleteAction($id,$panId)
    {
        $ligne=new Ligneproduit();
        $em=$this->getDoctrine()->getManager();
        $ligne=$em->getRepository(Ligneproduit::class)->findOneBy(array('idproduit' => $id,'idpanier' => $panId));
        $em->remove($ligne);
        $em->flush();
        return $this->redirectToRoute("cart");


    }

    public function updateupAction($id,$panId)
    {
        /*$request = $this->getRequest();
        $sc = $request->request->get('valeur');*/



        $em=$this->getDoctrine()->getManager();
        $ligne=$em->getRepository(Ligneproduit::class)->findOneBy(array('idproduit' => $id,'idpanier' => $panId));
        $ligne->setQuantite($ligne->getQuantite()+1);
        $em->persist($ligne);
        $em->flush();
        return $this->redirectToRoute("cart");


    }

    public function updatemoinsAction($id,$panId)
    {

        $em=$this->getDoctrine()->getManager();
        $ligne=$em->getRepository(Ligneproduit::class)->findOneBy(array('idproduit' => $id,'idpanier' => $panId));
        $ligne->setQuantite($ligne->getQuantite()-1);
        $em->persist($ligne);
        $em->flush();
        return $this->redirectToRoute("cart");


    }

    public function pdfAction()
    {
        $pageUrl = $this->generateUrl('/untitled/web/app_dev.php/cart', array(), true); // use absolute path!

        return new PdfResponse(
            $this->get('knp_snappy.pdf')->getOutput($pageUrl),
            'file.pdf'
        );
    }

    public function valideAction()
    {
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;

        $em=$this->getDoctrine()->getManager();
        $repo=$em->getRepository(Panier::class);
        $panier=$repo->findOneBy(array('etat' => 0, 'idutilisateur' =>$idd));
        $panId=$panier->getIdpanier();
        $panier->setEtat(1);
        $em->persist($panier);
        $em->flush();

        $q= $this->getDoctrine()->getEntityManager()->createQuery("select  p.idproduit,p.nomproduit,p.prix,l.quantite,p.quantite AS stock from HichemBundle\Entity\Ligneproduit l , HichemBundle\Entity\Produit p  where l.idpanier=$panId and p.idproduit=l.idproduit");
        $produits = $q->getResult();


        foreach ($produits as $produit) {

            $quant = $produit['stock'] - $produit['quantite'];
            $em = $this->getDoctrine()->getManager();
            $prod = $em->getRepository(Produit::class)->findOneBy(array('idproduit' => $produit['idproduit']));
            $prod->setQuantite($quant);
            $em->persist($prod);
            $em->flush();

        }

        $proj = $this->getDoctrine()->getRepository(Produit::class)->findAll();
        return $this->render("@Hichem/Front/listproduit.html.twig", array('Produit'=>$proj));
    }









     //   return $this->render('@Hichem/Front/cart.html.twig');





    /*public function indexfrontAction()
    {
        return $this->render('@Hichem/Default/indexfront.html.twig');
    }*/

    /*public function ajoutPanierAction(Request $request)
    {
        $Panier = new Panier();

        $form = $this->createForm(PanierType::class, $Panier);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Panier);
            $em->flush();
            return $this->redirectToRoute("ajoutPanier");
        }
        return $this->render("@Hichem/Back/ajoutPanier.html.twig",
            array('panier_form' => $form->createView()));
    }
    public function afficherPanierAction()
    {
        $proj = $this->getDoctrine()->getRepository(Panier::class)->findAll();
        $proj1 = $this->getDoctrine()->getRepository(Ligneproduit::class)->findAll();
        return $this->render("@Hichem/Back/afficherPanier.html.twig", array('Panier'=>$proj,'Ligneproduit'=>$proj1));
    }


    public function supprimerPanierAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Panier::class)->find($id);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherPanier");
    }

    public function supprimerLigneproduitAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Ligneproduit::class)->find($id);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherPanier");
    }

    public function modifierPanierAction($id,Request $request){
        $cars=$this->getDoctrine()->getRepository(Panier::class)->find($id);
        $form=$this->createForm(PanierType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherPanier");
        }
        return $this->render("@Hichem/Back/modifierPanier.html.twig",array("form_modifier"=>$form->createView()));
    }

    public function shopdetailsAction(Request $request,$idproduit)
    {

        $post = $this->getDoctrine()->getRepository(Produit::class)->find($idproduit);
        //$post1 = $this->getDoctrine()->getRepository(Panier::class)->findAll();
        $user = $this->container->get('security.token_storage')->getToken()->getUser();


        $ligneproduit=new Ligneproduit();
        $form=$this->createForm(LigneproduitType::class,$ligneproduit);

        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $ligneproduit->setUser($user);
            $em = $this->getDoctrine()->getManager();
            $ehsebb = $request->request->get('value');
            //$ligneproduit->setQuantite($ehsebb);
            $ligneproduit->setQuantite(10);
            $ligneproduit->setIdpanier(23);
            //$ligneproduit->setIdproduit($idproduit);
            $ligneproduit->setIdproduit(1);
            $em->persist($ligneproduit);
            $em->flush();
            $this->redirectToRoute('shopdetails');

        }
        return $this->render("@Hichem/Front/shopdetails.html.twig", array('Produit'=>$post,'user'=>$user,'ligneproduitform'=>$form->createView()));
    }

    public function listproduitAction()
    {
        $proj = $this->getDoctrine()->getRepository(Produit::class)->findAll();
        return $this->render("@Hichem/Front/listproduit.html.twig", array('Produit'=>$proj));
    }*/








}
