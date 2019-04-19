<?php

namespace HichemBundle\Controller;

use HichemBundle\Entity\Ligneproduit;

use HichemBundle\Entity\Panier;
use HichemBundle\Entity\Produit;
use HichemBundle\Form\LigneproduitType;
use HichemBundle\Form\PanierType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\ColumnChart;
use Symfony\Component\Form\Extension\Core\Type\TextType;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\CountryType;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Hichem/Default/index.html.twig');
    }


    public function cartAction(Request $request)
    {

        $nom = null;
        $form = $this->createFormBuilder()
            ->add('idproduit',TextType::class)
            ->getForm();
        $form->handleRequest($request);
        $nom = $form['idproduit']->getData();

        $event = new Ligneproduit();
        if ($form->isValid())
        {
            $event = $this->getDoctrine()->getRepository(Ligneproduit::class)->aloo($nom);
        }
        else {
            $event = $this->getDoctrine()->getRepository(Ligneproduit::class)->findAll();

        }

        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;

        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $username= $this->getUser()->getUserId() ;
        //  $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $repo=$this->getDoctrine()->getRepository(Panier::class);
        $panier=$repo->findOneBy(array('etat' => 0, 'idutilisateur' => $idd));
        $panId=$panier->getIdpanier();
        //$prods=$repo2->findBy(array('idPanier' =>$panier->getIdPanier()));
        $q= $this->getDoctrine()->getEntityManager()->createQuery("select p.idproduit,p.nomproduit,p.prix,l.quantite from HichemBundle\Entity\Ligneproduit l , HichemBundle\Entity\Produit p  where l.idpanier=$panId and p.idproduit=l.idproduit");
        $q2= $this->getDoctrine()->getEntityManager()->createQuery("select p.prix ,l.quantite   from HichemBundle\Entity\Ligneproduit l , HichemBundle\Entity\Produit p  where l.idpanier=$panId and p.idproduit=l.idproduit");
        //$prixProd=$q2->getQuery()->getArrayResult();
        $prixProd=$q2->getResult();

        $produits = $q->getResult();
        $total=0;
       /*foreach ($prixProd as $produit) {
            $total = $total + ($produit->getQuantite() * $produit->getPrix());
        }*/


        //$total=150;

        return $this->render('@Hichem/Front/cart.html.twig', ['controller_name'=>'panierController', 'produits'=>$produits,
                'total'=>$total,'Ligneproduit'=>$event,'form'=>$form->createView(),'panId'=>$panId,'prixProd'=>$prixProd
            ]);
    }


    public function checkoutAction()
    {
        return $this->render('@Hichem/Front/checkout.html.twig');
    }

    public function indexfrontAction()
    {
        return $this->render('@Hichem/Default/indexfront.html.twig');
    }

    public function ajoutPanierAction(Request $request)
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
    }



    public function statAction()
    {

        $pieChart = new PieChart();
        $em= $this->getDoctrine();
        $reservation = $em->getRepository(Ligneproduit::class)->findAll();


        $data=array();
        $stat=['idligne', 'quantite'];
        array_push($data,$stat);
        foreach($reservation as $reservations) {
            $nb = $reservations->getQuantite();
            $id = (string)$reservations->getIdligne();
            $stat=array();
            array_push($stat,$id,$nb);
            $stat=[$id,$nb];
            array_push($data ,$stat);

        }

        $pieChart->getData()->setArrayToDataTable(
            $data
        );

        $pieChart->getOptions()->setTitle('Statistique');
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
        $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
        $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
        $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
        $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);






        $q3= $this->getDoctrine()->getEntityManager()->createQuery("select u.username ,sum(l.quantite) AS number from AppBundle\Entity\User u , HichemBundle\Entity\Panier p ,HichemBundle\Entity\Ligneproduit l  where  u.id=p.idutilisateur and l.idpanier=p.idpanier GROUP BY u.username");
        $clients=$q3->getResult();




        $col = new ColumnChart();
        $data2=array();
        $stat2=['Nom Client' , 'Total Articles'];
        array_push($data2,$stat2);
        foreach($clients as $client) {

           $nom2= (string)$client['username'];
            $nb2 = $client['number'];
            $stat2=array();
            array_push($stat2,$nb2,$nom2);
            $stat2=[$nb2,$nom2];
            array_push($data2 ,$stat2);

        }

        $col->getData()->setArrayToDataTable(
            $data2
        );

        $col->getOptions()->setTitle('Best Clients ');
        $col->getOptions()->getTitleTextStyle()->setBold(true);
        $col->getOptions()->getTitleTextStyle()->setColor('#ea4335');
        $col->getOptions()->getTitleTextStyle()->setFontSize(22);
        $col->getOptions()->getAnnotations()->setAlwaysOutside(true);
        $col->getOptions()->getAnnotations()->getTextStyle()->setFontSize(20);
        $col->getOptions()->getAnnotations()->getTextStyle()->setColor('#000');
        $col->getOptions()->getAnnotations()->getTextStyle()->setAuraColor('none');
        $col->getOptions()->getVAxis()->setTitle('Rating (scale of 1-10)');
        $col->getOptions()->setWidth(900);
        $col->getOptions()->setHeight(500);










        return $this->render('@Hichem/Front/stat.html.twig', array('piechart' => $pieChart,'Ligneproduit'=>$reservation,'col' =>$col,'clients'=>$clients));


    }




}
